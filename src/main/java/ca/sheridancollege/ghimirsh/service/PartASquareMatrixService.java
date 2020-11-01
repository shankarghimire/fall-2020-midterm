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
	
	public PartASquareMatrix preparePartASquareMatrixService(PartASquareMatrix obj) {
		temp = obj;	
		System.out.println("Testing from the PartASquareMatrixService class...");
		fillMatrix(temp);	
		// input term to search
//		Scanner sc = new Scanner(System.in);
//		String str1 = "Test";
//		//System.out.println("Enter the search term : ");
//		//str1 = sc.next();
//		boolean searchResult = false;
//		char[][]tempMatrix = temp.getMatrix();
//		searchResult = beginSearch(tempMatrix, str1);
//		System.out.println("You search for : " + str1);
//		String result = (searchResult) ? "Found" : "Not Found";
//		System.out.println(result);
		return temp;
		
	}
	
	public PartASquareMatrix searchMatrix(PartASquareMatrix obj) {
		temp = obj;
		// input term to search
		//Scanner sc = new Scanner(System.in);
		String str1 = "";
		str1 = obj.getSearchValue();
		// System.out.println("Enter the search term : ");
		// str1 = sc.next();
		boolean searchResult = false;
		char[][] tempMatrix = temp.getMatrix();
		searchResult = beginSearch(tempMatrix, str1);
		temp.setSearchResult(searchResult);
		System.out.println("You search for : " + str1);
		String result = (searchResult) ? "Found" : "Not Found";
		System.out.println(result);
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
	}
	
	private void inputSearchTerm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the search term : ");
		String str1 = sc.next();
		
	}
	private boolean beginSearch(char[][]data, String searchWord) {
		boolean finalResult = false;
		char currentLetter;
		char firstLetter = searchWord.charAt(0);
		outerloop:
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				currentLetter = data[i][j];
				if(currentLetter == firstLetter) {
					finalResult = searchRight(data, i, j, searchWord);
					if(finalResult) {
						break outerloop;
					}
					else {
						continue;
					}
				}
			}
		}
		
		return finalResult;
	}
	
	//method to search term in right direction
	private boolean searchRight(char[][]data, int startX, int startY, String searchWord) {
		boolean searchResult = false;
		int rowSize= 0; 
		int colSize =  0;
		int searchWordLength = searchWord.length();
		char[] temp = new char[searchWordLength];
		int index = 0;
		int totalTimesToRepeat = startY + searchWord.length();
		rowSize = colSize = data.length;
		for(int yPosition = startY; yPosition < totalTimesToRepeat; yPosition++) {
			if(yPosition >= colSize || yPosition >= totalTimesToRepeat) {
				break;
			}
			else {
				temp[index] = data[startX][yPosition];
				if(temp[index] != searchWord.charAt(index)) {
					searchResult = false;
					break;
				}
				else {
					searchResult = true;
				}
				index++;
			}	
		}
		
		return searchResult;
		
//		String strTemp = String.valueOf(temp);
//		if(strTemp.equalsIgnoreCase(searchWord)){
//			return true;
//		}
//		else {
//			return false;
//		}
		
//		while( yPosition < colSize || yPosition < charLength) {
//			
//			
//		}
		
		//return searchResult;
	}
}

