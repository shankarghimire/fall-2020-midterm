package ca.sheridancollege.ghimirsh.beans;

import java.util.Arrays;
import java.util.List;

public class PartASquareMatrix {
	private int rowSize = 5;
	private char[][] matrix;
	private List<Character> listMatrix ;
	private boolean searchResult;
	private String searchValue;
	
	public PartASquareMatrix() {
		
	}
	
	public PartASquareMatrix(int rowSize, char[][] matrix) {		
		this.rowSize = rowSize;
		this.matrix = matrix;
	}

	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public char[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}
	
	public List<Character> getListMatrix() {
		return listMatrix;
	}

	public void setListMatrix(List<Character> listMatrix) {
		this.listMatrix = listMatrix;
	}

	public boolean isSearchResult() {
		return searchResult;
	}

	public void setSearchResult(boolean searchResult) {
		this.searchResult = searchResult;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public void printMatrix() {
		System.out.println("Given Square Matrix size: " + this.getRowSize());
		System.out.println("Given SquareMatrix is : ");
		System.out.println();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	
	
	@Override
	public String toString() {
		return "PartASquareMatrix [rowSize=" + rowSize + ", matrix=" + Arrays.toString(matrix) + ", listMatrix="
				+ listMatrix + "]";
	}
	

	
	
} 
