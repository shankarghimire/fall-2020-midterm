package ca.sheridancollege.ghimirsh.service;

import java.util.Random;

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
		
		//sets matrix to the object
		obj.setMatrix(tempMatrix);
		
		//print matrix elements on console for testing
		obj.printMatrix();
		
	}
	
		
}
