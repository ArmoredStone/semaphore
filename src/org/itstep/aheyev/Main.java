package org.itstep.aheyev;

import java.util.GregorianCalendar;
import java.util.concurrent.Semaphore;

public class Main {
	public static int[][] matrix = MatrixCreator.createMatrix();
	static int currentLine = 0;
	static long matrixSumm = 0;
	static Runnable calcOneLine = new Runnable() {
		@Override
		public void run() {
			if (currentLine == 60) {
				return;
			}
			for (int i = 0; i < 60; i++) {
				matrixSumm+= (long) matrix[currentLine][i];
			}
//			System.out.print(Main.getMatrixSumm());
			currentLine++;

		}
	};

	public static void setMatrixSumm(long matrixSumm) {
		Main.matrixSumm = matrixSumm;
	}

	public static long getMatrixSumm() {
		return matrixSumm;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(new GregorianCalendar().getTimeInMillis());
		Semaphore sem = new Semaphore(1);
		for (int i = 0; i < 13; i++) {
			sem.acquire();
			Thread t1 = new Thread(calcOneLine);
			Thread t2 = new Thread(calcOneLine);
			Thread t3 = new Thread(calcOneLine);
			Thread t4 = new Thread(calcOneLine);
			Thread t5 = new Thread(calcOneLine);
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			sem.release();
		}
		System.out.println(getMatrixSumm());
		System.out.println(new GregorianCalendar().getTimeInMillis());
	}

}
