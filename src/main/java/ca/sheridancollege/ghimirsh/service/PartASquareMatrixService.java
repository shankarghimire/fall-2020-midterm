package ca.sheridancollege.ghimirsh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Service;



import ca.sheridancollege.ghimirsh.beans.PartASquareMatrix;

@Service
public class PartASquareMatrixService {
	private PartASquareMatrix temp;

	public PartASquareMatrixService() {
		
	}
	
	public PartASquareMatrix testPartASquareMatrixService(PartASquareMatrix obj) {
		temp = obj;
		
		System.out.println("Testing from the PartASquareMatrixService class...");
		fillMatrix(obj);
		return temp;
		
	}
	
	private void fillMatrix(PartASquareMatrix obj) {
		int rowSize = obj.getRowSize();
		char[][] tempMatrix = new char[rowSize][rowSize];
		
		Random r = new Random();
		for(int i = 0; i < tempMatrix.length; i++) {
			for(int j = 0; j < tempMatrix[i].length; j++ ) {
				char c = (char)(r.nextInt(26) + 'A');
				//System.out.print(c + "  ");
				tempMatrix[i][j] = c;
			}
		}
		
		//Create ArrayList 
		List<Character> tempList = new ArrayList<>();
		for(int i = 0; i < tempMatrix.length; i++) {
			for(int j = 0; j < tempMatrix[i].length; j++ ) {
				tempList.add(tempMatrix[i][j]);
			}
		}
		//Assigns tempList to class properties
		obj.setListMatrix(tempList);
		
		//sets matrix to the object
		obj.setMatrix(tempMatrix);
		
		//print arrayList
		System.out.println(obj.getListMatrix());
		
		//print matrix elements on console for testing
		obj.printMatrix();	
		
		//input term to search
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the search term : ");
		String str1 = sc.next();
		boolean result = searchRight(tempMatrix,0,0,str1);
	}
	
	private void inputSearchTerm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the search term : ");
		String str1 = sc.next();
		
	}
	
	//method to search term in right direction
	private boolean searchRight(char[][]data, int startX, int startY, String searchWord) {
		boolean searchResult = false;
		
		return searchResult;
	}
}

