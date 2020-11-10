package ca.sheridancollege.ghimirsh.beans;

import java.util.Arrays;
import java.util.List;

public class PartASquareMatrix {
	private int rowSize = 5;
	private char[][] matrix;
	private List<Character> listMatrix ;
	private boolean searchResult;
	private String searchValueResult = "NotApplicable";
	private String searchValue;
	private int startRow;
	private int startCol;
	private int endRow;
	private int endCol;
	
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

	public String getSearchValueResult() {
		return searchValueResult;
	}

	public void setSearchValueResult(String searchValueResult) {
		this.searchValueResult = searchValueResult;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartCol() {
		return startCol;
	}

	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getEndCol() {
		return endCol;
	}

	public void setEndCol(int endCol) {
		this.endCol = endCol;
	}

	public void printMatrix() {
		//For Testing on console
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
				+ listMatrix + ", searchResult=" + searchResult + ", searchValue=" + searchValue + ", startRow="
				+ startRow + ", startCol=" + startCol + ", endRow=" + endRow + ", endCol=" + endCol + "]";
	}
	
	
	
	

	
	
} 
