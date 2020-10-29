package ca.sheridancollege.ghimirsh.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSRFormat {
	private boolean readFromFile;
	private int rowSize;
	private int colSize;
	private double [][]matrix;
	private double thresHold = 0.5;
	private double[] arrV;
	private int[] arrJ;
	private int[] arrI;
	private List<Double> listV = new ArrayList<>();
	private List<Integer> listJ = new ArrayList<>();
	private List<Integer> listI = new ArrayList<>();
	private String userOption;
	
	private String[] availableOptions = {"-Choose an Option-","V", "J","I"};
	public CSRFormat() {
		
	}
	
	public boolean isReadFromFile() {
		return readFromFile;
	}

	public void setReadFromFile(boolean readFromFile) {
		this.readFromFile = readFromFile;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public double getThresHold() {
		return thresHold;
	}

	public void setThresHold(double thresHold) {
		this.thresHold = thresHold;
	}

	public double[] getArrV() {
		return arrV;
	}

	public void setArrV(double[] arrV) {
		this.arrV = arrV;
	}

	public int[] getArrJ() {
		return arrJ;
	}

	public void setArrJ(int[] arrJ) {
		this.arrJ = arrJ;
	}

	public int[] getArrI() {
		return arrI;
	}

	public void setArrI(int[] arrI) {
		this.arrI = arrI;
	}

	public List<Double> getListV() {
		return listV;
	}

	public void setListV(List<Double> listV) {
		this.listV = listV;
	}

	public List<Integer> getListJ() {
		return listJ;
	}

	public void setListJ(List<Integer> listJ) {
		this.listJ = listJ;
	}

	public List<Integer> getListI() {
		return listI;
	}

	public void setListI(List<Integer> listI) {
		this.listI = listI;
	}

	public String getUserOption() {
		return userOption;
	}

	public void setUserOption(String userOption) {
		this.userOption = userOption;
	}

	public String[] getAvailableOptions() {
		return availableOptions;
	}

	public void setAvailableOptions(String[] availableOptions) {
		this.availableOptions = availableOptions;
	}
	
	
	
	

	@Override
	public String toString() {
		return "CSRFormat [readFromFile=" + readFromFile + ", rowSize=" + rowSize + ", colSize=" + colSize + ", matrix="
				+ Arrays.toString(matrix) + ", thresHold=" + thresHold + ", arrV=" + Arrays.toString(arrV) + ", arrJ="
				+ Arrays.toString(arrJ) + ", arrI=" + Arrays.toString(arrI) + ", listV=" + listV + ", listJ=" + listJ
				+ ", listI=" + listI + ", userOption=" + userOption + ", availableOptions="
				+ Arrays.toString(availableOptions) + "]";
	}

	public void printMatrix() {
		System.out.println("Auto-generated sparce matrix : ");
		System.out.println();
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%7.1f",matrix[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}		
}
