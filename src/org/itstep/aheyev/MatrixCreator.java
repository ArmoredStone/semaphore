package org.itstep.aheyev;

public class MatrixCreator {
	public static int[][] createMatrix() {
		int[][] matrix = new int[60][60];
		for (int i = 0; i < 60; i++) {
			System.out.print("\n");
			for (int j = 0; j < 60; j++) {
//				matrix[i][j] = (int) Math.random()+1;
				matrix[i][j] = (int) ((Math.random() * 5981) + 20);
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.print("\n");
		return matrix;
	}

}
