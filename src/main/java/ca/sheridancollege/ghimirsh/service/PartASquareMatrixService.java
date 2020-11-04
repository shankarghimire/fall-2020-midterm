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
				finalResult = searchHorizontal(tempData, searchWord);
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
				finalResult = searchVertical(tempData, searchWord);
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
	private boolean searchHorizontal(String data, String searchWord) {
		boolean searchResult = false;
		searchWord = searchWord.toUpperCase();
		searchResult = data.contains(searchWord);
		if (!searchResult) {
			StringBuilder data1 = new StringBuilder();
			data1.append(data);
			data1 = data1.reverse();
			data = String.valueOf(data1);
			searchResult = data.contains(searchWord);
		}
		return searchResult;
	}

	/// search in vertical direction
	private boolean searchVertical(String data, String searchWord) {
		boolean searchResult = false;
		searchWord = searchWord.toUpperCase();
		searchResult = data.contains(searchWord);
		if (!searchResult) {
			StringBuilder data1 = new StringBuilder();
			data1.append(data);
			data1 = data1.reverse();
			data = String.valueOf(data1);
			searchResult = data.contains(searchWord);
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
			StringBuilder data1 = new StringBuilder();
			data1.append(data);
			data1 = data1.reverse();
			data = String.valueOf(data1);
			searchResult = data.contains(searchWord);
		}
		return searchResult;
	}

	/// search in secondary diagonal direction
	private boolean searchSecondaryDiagonal(String data, String searchWord) {
		boolean searchResult = false;
		searchWord = searchWord.toUpperCase();
		searchResult = data.contains(searchWord);
		if (!searchResult) {
			StringBuilder data1 = new StringBuilder();
			data1.append(data);
			data1 = data1.reverse();
			data = String.valueOf(data1);
			searchResult = data.contains(searchWord);
		}
		return searchResult;
	}
}
