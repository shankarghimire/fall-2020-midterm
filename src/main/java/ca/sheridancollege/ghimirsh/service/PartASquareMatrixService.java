package ca.sheridancollege.ghimirsh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		// for testing purpose on console
		// input term to search
		// Scanner sc = new Scanner(System.in);
		String str1 = "";
		str1 = obj.getSearchValue();
		// System.out.println("Enter the search term : ");
		// str1 = sc.next();
		boolean searchResult = false;
		char[][] tempMatrix = temp.getMatrix();
		searchResult = beginSearch(tempMatrix, str1);
		temp.setSearchResult(searchResult);
		if(searchResult) {
			temp.setSearchValueResult("Found");
		}
		else {
			temp.setSearchValueResult("NotFound");
		}

		// testing purpose
		System.out.println("You search for : " + str1);
		String result = (searchResult) ? "Found" : "Not Found";
		System.out.println(result);
		return temp;
	}

	private void fillMatrix(PartASquareMatrix obj) {
		int rowSize = obj.getRowSize();
		char[][] tempMatrix = new char[rowSize][rowSize];

		Random r = new Random();
		for (int i = 0; i < tempMatrix.length; i++) {
			for (int j = 0; j < tempMatrix[i].length; j++) {
				char c = (char) (r.nextInt(26) + 'A');
				// System.out.print(c + " ");
				tempMatrix[i][j] = c;
			}
		}

		// Create ArrayList
		List<Character> tempList = new ArrayList<>();
		for (int i = 0; i < tempMatrix.length; i++) {
			for (int j = 0; j < tempMatrix[i].length; j++) {
				tempList.add(tempMatrix[i][j]);
			}
		}
		// Assigns tempList to class properties
		obj.setListMatrix(tempList);

		// sets matrix to the object
		obj.setMatrix(tempMatrix);

		// print arrayList
		System.out.println(obj.getListMatrix());

		// print matrix elements on console for testing
		obj.printMatrix();
	}

	private boolean beginSearch(char[][] data, String searchWord) {
		boolean finalResult = false;
		String tempData = "";
		// calls horizontalSearch method
		if (!finalResult) {
			for (int i = 0; i < data.length; i++) {
				tempData = String.valueOf(data[i]);
				// finalResult = searchRight2(tempData, searchWord);
				finalResult = searchHorizontal(tempData, searchWord,i);
				if (finalResult) {
					break;
				}
			}
		}
		// calls vertialSearch method
		if (!finalResult) {
			// int index = 0;
			char[] tempColumn = new char[data.length];
			outerloop: for (int i = 0; i < data.length; i++) {
				int index = 0;
				for (int j = 0; j < data.length; j++) {
					tempColumn[index] = data[j][i];
					index++;
				}
				tempData = String.valueOf(tempColumn);
				// finalResult = searchRight2(tempData, searchWord);
				finalResult = searchVertical(tempData, searchWord,i);
				if (finalResult) {
					break outerloop;
				}
			}
		}

		// calls method to search in Main diagonal
		if (!finalResult) {
			int rowIndex = 0;
			int colIndex = 0;
			char[] dataMainDiagonal = new char[data.length];
			for (int index = 0; index < data.length; index++) {
				dataMainDiagonal[index] = data[rowIndex][colIndex];
				rowIndex++;
				colIndex++;
			}
			tempData = String.valueOf(dataMainDiagonal);
			finalResult = searchMainDiagonal(tempData, searchWord);
		}

		// calls method to search in Secondary diagonal
		if (!finalResult) {

			int rowIndex = 0;
			int colIndex = data.length - 1;
			char[] dataSecondaryDiagonal = new char[data.length];
			for (int index = 0; index < data.length; index++) {
				dataSecondaryDiagonal[index] = data[rowIndex][colIndex];
				rowIndex++;
				colIndex--;
			}
			tempData = String.valueOf(dataSecondaryDiagonal);
			finalResult = searchSecondaryDiagonal(tempData, searchWord);
		}
		return finalResult;
	}

	// Search in Horizontal direction
	private boolean searchHorizontal(String data, String searchWord, int rowNo) {
		boolean searchResult = false;
searchWord = searchWord.toUpperCase();
		
		//Searches the word from Left to Right direction
		searchResult = data.contains(searchWord);
		
		//if not found in above case, then searches the word from Right to Left direction
		if (!searchResult) {
			searchWord = new StringBuilder(searchWord).reverse().toString();
			searchResult = data.contains(searchWord);
		}
		if(searchResult) {
			temp.setStartRow(rowNo);
			int startColPos = data.indexOf(searchWord);
			temp.setStartCol(startColPos);
			
			temp.setEndRow(rowNo);
			int endColIndex = startColPos + (searchWord.length() - 1);
			temp.setEndCol(endColIndex);
			
			//testing on console
			System.out.println("Search Word : " + searchWord);
			System.out.println("Start Postion : " + temp.getStartRow() + ", " + temp.getStartCol());
			System.out.println("Start Postion : " + temp.getEndRow() + ", " + temp.getEndCol());
			
		}
		return searchResult;
	}

	/// search in vertical direction
	private boolean searchVertical(String data, String searchWord, int colNo) {
		boolean searchResult = false;
		searchWord = searchWord.toUpperCase();
		searchResult = data.contains(searchWord);
		if (!searchResult) {
			searchWord = new StringBuilder(searchWord).reverse().toString();
			searchResult = data.contains(searchWord);
		}
		
		if(searchResult) {
			temp.setStartCol(colNo);
			
			int startRowPos = data.indexOf(searchWord);
			temp.setStartRow(startRowPos);
			
			temp.setEndCol(colNo);
			int endRowPos = startRowPos + (searchWord.length() - 1);
			temp.setEndRow(endRowPos);
			
			//testing on console
			System.out.println("Search Word : " + searchWord);
			System.out.println("Start Postion : " + temp.getStartRow() + ", " + temp.getStartCol());
			System.out.println("Start Postion : " + temp.getEndRow() + ", " + temp.getEndCol());
			
		}
		return searchResult;
	}

	/// search in main diagonal direction
	private boolean searchMainDiagonal(String data, String searchWord) {
		boolean searchResult = false;
		searchWord = searchWord.toUpperCase();
		searchResult = data.contains(searchWord);
		// Search the reverse value
		if (!searchResult) {
			searchWord = new StringBuilder(searchWord).reverse().toString();
			searchResult = data.contains(searchWord);
		}
		if(searchResult) {
			int startIndex = data.indexOf(searchWord);
			temp.setStartRow(startIndex);
			temp.setStartCol(startIndex);
			int endIndex = startIndex + (searchWord.length() - 1);
			temp.setEndRow(endIndex);
			temp.setEndCol(endIndex);
			//testing on console
			System.out.println("Search Word : " + searchWord);
			System.out.println("Start Postion : " + temp.getStartRow() + ", " + temp.getStartCol());
			System.out.println("Start Postion : " + temp.getEndRow() + ", " + temp.getEndCol());			
		}
		return searchResult;
	}

	/// search in secondary diagonal direction
	private boolean searchSecondaryDiagonal(String data, String searchWord) {
		boolean searchResult = false;
		//Converts to upper case to make the case insensitive
		searchWord = searchWord.toUpperCase();
		
		//Searches the text from Top-left to Right-bottom direction
		searchResult = data.contains(searchWord);
		
		//if not found, then searches the text from Right-Bottom to Top-Left direction
		if (!searchResult) {
			searchWord = new StringBuilder(searchWord).reverse().toString();
			searchResult = data.contains(searchWord);
		}
		
		//if search matched,
		//finds the row and column position of the searched text in the matrix
		if(searchResult) {
			int startRowIndex = data.indexOf(searchWord);
			int startColIndex = (data.length()-1) - startRowIndex;
			
			temp.setStartRow(startRowIndex);
			temp.setStartCol(startColIndex);
			
			int endRowIndex = startRowIndex + (searchWord.length() - 1);
			int endColIndex = (data.length()-1) - endRowIndex;
			temp.setEndRow(endRowIndex);
			temp.setEndCol(endColIndex);
			
			//testing on console
			System.out.println("Search Word : " + searchWord);
			System.out.println("Start Postion : " + temp.getStartRow() + ", " + temp.getStartCol());
			System.out.println("Start Postion : " + temp.getEndRow() + ", " + temp.getEndCol());
			
		}
		return searchResult;
	}
}
