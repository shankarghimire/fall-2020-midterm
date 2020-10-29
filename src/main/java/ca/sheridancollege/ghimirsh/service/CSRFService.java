package ca.sheridancollege.ghimirsh.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import ca.sheridancollege.ghimirsh.beans.CSRFormat;

@Service
public class CSRFService {
	
	private CSRFormat temp;
	
	public CSRFService() {
		
	}

	public CSRFormat testCSRFService(CSRFormat obj) {
		//System.out.println("CSRFService class testing....");
		System.out.println(obj.toString()); //for Testing
		temp = obj;	
		
		if(temp.isReadFromFile()) {
			readMatrixFromFile(temp);
		}else {
			//calls method to fill Sparce Matrix elements
			fillMatrix(temp);
			
			//method call to write matrix to text file
			writeMatrixToFile(temp);
			
			//calls method to print matrix on console for testing purpose
			temp.printMatrix();
		}
		
		
		//calls method that calculate the array V, J and I for the CSR format
		calculateVJI(temp);
		
		
		return temp;
	}
	
	private void fillMatrix(CSRFormat obj) {
		//Object to generate random number
		Random rand = new Random();
		
		double randValue = 0.0;
		
		//variable to hold threshhold value 
		double th = obj.getThresHold();
		
		//Creates a 2D array-matrix to hold sparce matrix elements as size specified by user
		int rowSize = obj.getRowSize();
		int colSize = obj.getColSize();
		double[][] mat = new double[rowSize][colSize];
		
		//code to fill every sparce matrix element
		//first for loop to generate row-value
		for (int i = 0; i < mat.length; i++) {
			
			//second for loop to generate column value in each row
			for (int j = 0; j < mat[i].length; j++) {
				//to generate random value
				randValue = Math.random();
				
				//To check the random value with the threshold value to convert to 0.0
				if (randValue < th) {
					mat[i][j] = 0.0;
				} else {
					
					
					//Code to round off the numbers upto 1 digit after decimal place
					double elementValue = Math.round(randValue * 100) / 10;
					//testVal = testVal / 10;
					//Generate random value either 0 or 1 and assigns the + or - sign in front of the number
					int randomValueForSign = rand.nextInt(2);
					if (randomValueForSign == 1) {
						mat[i][j] = -1 * elementValue;  //converts the value to negative
					} else {
						mat[i][j] = elementValue;
					}
				}
			}
		}
		obj.setMatrix(mat);
		//obj.printMatrix();
	}

	// method to calculate V, J and I
	private void calculateVJI(CSRFormat obj) {
		
		//Code to count total non-zero elements in the matrix
		int totalNonZeroElement = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0.0) {
					totalNonZeroElement++;
				}
			}
		}
		
		//code to declare V, J and I array
		double[]tempArrV = new double[totalNonZeroElement];
		int [] tempArrJ = new int[totalNonZeroElement];
		int totalRows = obj.getRowSize();
		totalRows = totalRows + 1;
		int[] tempArrI = new int[totalRows];
		
		//Code to calculate V, J & I
		tempArrI[0] = 0;
		int count = 0;
		int index = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0 ) {
					tempArrV[index] = temp;
					tempArrJ[index] = j;
					count++;
					index++;
				}
			}
			tempArrI[i+1] = count;
		}
		
		//for testing purpose
		System.out.println();
		System.out.print("V : ");
		for(double v: tempArrV) {
			System.out.print(v + ", ");
		}
		System.out.println();
		System.out.print("J : ");
		for(int j: tempArrJ) {
			System.out.print(j + ", ");
		}
		System.out.println();
		System.out.print("I : ");
		for(int i: tempArrI) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		//Assigning to object using setter methods
		obj.setArrV(tempArrV);
		obj.setArrJ(tempArrJ);
		obj.setArrI(tempArrI);
		
		
		//Creating temp List for V, J & I
		List<Double> tempListV = new ArrayList<>();
		List<Integer>tempListJ = new ArrayList<>();
		List<Integer>tempListI = new ArrayList<>();
		
		tempListI.add(0);
		int countElement = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0 ) {
					tempListV.add(temp);
					tempListJ.add(j);				
					countElement++;
				}
			}
			tempListI.add(countElement);
		}
			
		//Assigning the tempList to Object
		obj.setListV(tempListV);
		obj.setListJ(tempListJ);
		obj.setListI(tempListI);
			
		//printing for testing purpose
		System.out.println("V: " + obj.getListV());
		System.out.println("J: " + obj.getListJ());
		System.out.println("I: " + obj.getListI());
		
	}
	
	private void readMatrixFromFile(CSRFormat obj) {
		FileReader fr;
		BufferedReader br;
		int rowSize = 0;
		int colSize = 0;
		int lineCount = 0;
		String line;
		String data;
		try {
			
			File file;
			StringTokenizer st;
			double[][] tempMatrix ;
			//file = new ClassPathResource("output.txt").getFile();
			file = new ClassPathResource("MatrixFile.txt").getFile();
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			line = br.readLine();
			data = new String();
			if(line != null) {
				st = new StringTokenizer(line);
				data = st.nextToken();
				rowSize = Integer.parseInt(data);
				data = st.nextToken();
				colSize = Integer.parseInt(data);
			}
			obj.setRowSize(rowSize);
			obj.setColSize(colSize);
			tempMatrix = new double[rowSize][colSize];
			
			//To read first line for matrix size
			
			
			//String data = new String();
			//double[][] tempMatrix;
			lineCount = 0;
			int rowIndex = 0;
			int colIndex = 0;
			while(line != null) {
				colIndex = 0;
				lineCount++;		
				if(lineCount > 1) {		
					st = new StringTokenizer(line);
					while(st.hasMoreTokens()) {
						double element = Double.parseDouble(st.nextToken());
						tempMatrix[rowIndex][colIndex] = element;
						colIndex++;
					}
					rowIndex++;
				}
				//data += line + "\n";
				line = br.readLine();
				
			}
			//System.out.println("Reading data from txt file : " +  data);
			//fillMatrix(temp);
			//temp = objCSRFService.testCSRFService(temp);
			obj.setMatrix(tempMatrix);
			
			System.out.println("Printed from Controller");
			obj.printMatrix();
			//calculateVJI(temp);
			System.out.println(obj.toString());
			//return "output";
		}catch(IOException e) {
			System.out.println(e.getMessage());
			//return e.getMessage();
			//br.close();
		}
		finally {
			//br.close();
			
		}
	}
	
	private void writeMatrixToFile(CSRFormat obj) {
		File file;
		FileWriter fw;
		BufferedWriter bw;
		int rowSize = 0;
		int colSize = 0;
		double element = 0;
		String line;
		try {
			//file = new ClassPathResource("outputMatrix.txt").getFile();
			//file = new File("classpath:resources/static/output1.txt");
			file = new File("output2.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			rowSize = obj.getRowSize();
			colSize = obj.getColSize();
			
			line = String.valueOf(rowSize)+ " " + String.valueOf(colSize);
			bw.write(line);
			bw.newLine();
			double[][] tempMatrix = obj.getMatrix();
			for(int i = 0; i < tempMatrix.length; i++ ) {
				line = "";
				for(int j = 0; j < tempMatrix[i].length; j++) {
					element = tempMatrix[i][j];
					line += String.valueOf(element) +" ";					
				}
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("");			
		}
	}
	
}
