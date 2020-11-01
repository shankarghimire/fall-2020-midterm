package ca.sheridancollege.ghimirsh.service;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		//testing purpose
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
	
//	private void inputSearchTerm() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the search term : ");
//		String str1 = sc.next();
//		
//	}
	
	/*
	private boolean beginSearch(char[][]data, String searchWord) {
		boolean finalResult = false;
		char currentLetter;
		searchWord = searchWord.toUpperCase();
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
//					else {
//						continue;
//					}
				}
				if(currentLetter == firstLetter) {
					finalResult = searchLeft(data, i, j, searchWord);
					if(finalResult) {
						break outerloop;
					}
//					else {
//						continue;
//					}
				}
//				else {
//					continue;
//				}
			}
		}
		
		return finalResult;
	}
	
	*/
	private boolean beginSearch(char[][]data, String searchWord) {
		boolean finalResult = false;
		String tempData = "";
		//calls horizontalSearch method
		if(!finalResult) {
			for(int i = 0; i < data.length; i++) {
				tempData = String.valueOf(data[i]);
				//finalResult = searchRight2(tempData, searchWord);
				finalResult = searchHorizontal(tempData,searchWord);
				if(finalResult) {
					break;
				}
			}
		}
		//calls vertialSearch method
		if (!finalResult) {
			//int index = 0;
			char[] tempColumn = new char[data.length];
			outerloop: for (int i = 0; i < data.length; i++) {
				int index = 0;
				for (int j = 0; j < data.length; j++) {
					tempColumn[index] = data[j][i];
					index++;
				}
				tempData = String.valueOf(tempColumn);
				// finalResult = searchRight2(tempData, searchWord);
				finalResult = searchHorizontal(tempData, searchWord);
				if (finalResult) {
					break outerloop;
				}
			}
		}
			
		return finalResult;
	}
	
	
	
	//method to search in right direction
	/*
	private boolean searchRight(char[][]data, int startX, int startY, String searchWord) {
		boolean searchResult = false;
		int rowSize= 0; 
		int colSize =  0;
		char ch1,ch2;
		searchWord = searchWord.toUpperCase();
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
				ch1 = data[startX][yPosition];
				ch2 = searchWord.charAt(index);
				temp[index] = ch1;
				//if(temp[index] != searchWord.charAt(index)) {
				if(ch1 != ch2 ) {
					//searchResult = false;
					break;
				}
				index++;
			}	
		}
		String tempString = String.valueOf(temp);
		tempString = tempString.toUpperCase();
		if(tempString.equalsIgnoreCase(searchWord)) {
			searchResult = true;
		}
		else {
			searchResult = false;
		}
		return searchResult;
	}*/
	
	//method to search in left direction
	/*
		private boolean searchLeft(char[][]data, int startRow, int startCol, String searchWord) {
			boolean searchResult = false;
			int rowSize= 0; 
			int colSize =  0;
			char ch1,ch2;
			searchWord = searchWord.toUpperCase();
			int searchWordLength = searchWord.length();
			char[] temp = new char[searchWordLength];
			int index = 0;
			int totalTimesToRepeat = startCol - searchWord.length();
			rowSize = colSize = data.length;
			for(int colPosition = startCol; colPosition >= 0 ; colPosition--) {
				if(colPosition < 0 || colPosition <= totalTimesToRepeat) {
					break;
				}
				else {
					ch1 = data[startRow][colPosition];
					ch2 = searchWord.charAt(index);
					temp[index] = ch1;
					//if(temp[index] != searchWord.charAt(index)) {
					if(ch1 != ch2 ) {
						//searchResult = false;
						break;
					}
					index++;
				}	
			}
			String tempString = String.valueOf(temp);
			tempString = tempString.toUpperCase();
			if(tempString.equalsIgnoreCase(searchWord)) {
				searchResult = true;
			}
			else {
				searchResult = false;
			}
			return searchResult;
		}
		*/
		//Method Next:
		//method to search in left direction
		/*
		private boolean searchLeft2(String data, String searchWord) {
			boolean searchResult = false;
			StringBuilder data1 = new StringBuilder();
			data1.append(data);
			data1 = data1.reverse();
			data =String.valueOf(data1);
			searchResult = data.contains(searchWord);
			return searchResult;
		}
		*/
		//method 2:
		//Search Right side Direction
		/*
		private boolean searchRight2(String data, String searchWord) {
			boolean searchResult = false;	
			searchWord = searchWord.toUpperCase();
			searchResult = data.contains(searchWord);
			return searchResult;
		}
		*/
		//Search in Horizontal direction
		private boolean searchHorizontal(String data, String searchWord) {
			boolean searchResult = false;
			searchWord = searchWord.toUpperCase();
			searchResult = data.contains(searchWord);
			if(!searchResult) {
				StringBuilder data1 = new StringBuilder();
				data1.append(data);
				data1 = data1.reverse();
				data =String.valueOf(data1);
				searchResult = data.contains(searchWord);
			}
			return searchResult;
		}
		
		///search in vertical direction
		private boolean searchVertical(String data, String searchWord) {
			boolean searchResult = false;
			searchWord = searchWord.toUpperCase();
			searchResult = data.contains(searchWord);
			if(!searchResult) {
				StringBuilder data1 = new StringBuilder();
				data1.append(data);
				data1 = data1.reverse();
				data =String.valueOf(data1);
				searchResult = data.contains(searchWord);
			}
			return searchResult;
		}
		
		
}

