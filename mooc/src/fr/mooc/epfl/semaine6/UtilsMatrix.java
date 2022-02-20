package fr.mooc.epfl.semaine6;

import java.util.InputMismatchException;
import java.util.Scanner;

// Note : le  message de mise en garde de Eclipse:
// the serializable class CustomException does not declare a static
// final serialVersionUID field of type long
// peut etre neglig'e.

class CustomException extends Exception {

	public CustomException(String string) {
		super(string);
	}

}

/**
 * @author Fernand SOUALO
 *
 */
class UtilsMatrix {
	public static int[][] multiply(int[][] mat1, int[][] mat2) throws CustomException {
		checkMatrix(mat1);
		checkMatrix(mat2);
		
		int rows1 = mat1.length;
		int cols1 = mat1[0].length;
		int rows2 = mat2.length;
		int cols2 = mat2[0].length;
		
		if (cols1 != rows2) {
			throw new CustomException("Les tailles des matrices doivent correspondre");
		}

		int[][] result = new int[rows1][cols2];
		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < cols2; j++) {
				for (int k = 0; k < rows2; k++) {
					result[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}
		return result;
	}

	private static int readNextInt(Scanner scanner) throws CustomException {
		int val = -1;
		try {
			val = scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new CustomException("Vous devez entrer un nombre");
		}
		if (val <= 0) {
			throw new CustomException("Vous devez entrer un nombre strictement positif !");
		}
		System.out.println("lu = " + val);
		return val;

	}

	public static int[][] readMatrix() throws CustomException {
		Scanner scanner = new Scanner(System.in);

		int row = -1;
		int col = -1;

		System.out.println("Nouvelle matrice");

		System.out.print("\t Entrez nombre de lignes : ");
		row = readNextInt(scanner);
		System.out.print("\t Entrez nombre de colonnes : ");
		col = readNextInt(scanner);

		int[][] result = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("\t Contenu cellule [" + i + "][" + j + "] : ");
					result[i][j] = readNextInt(scanner);
					try {
						result[i][j] = scanner.nextInt();
					} catch (InputMismatchException e) {
						throw new CustomException("Vous devez entrer un nombre");
					}
			}
		}
		return result;
	}
	
	/**
	 * @param matrice
	 * @throws CustomException
	 */
	public static void checkMatrix(int[][] matrice) throws CustomException {
		if (matrice == null) {
			throw new CustomException("La matrice doit etre initialisee");
		}
		
		if (matrice.length == 0) {
			throw new CustomException("La matrice ne doit pas etre vide");
		}
		int lineLength = matrice[0].length;
		for (int[] lines : matrice) {
			if (lineLength != lines.length) {
				throw new CustomException("Toutes les lignes de la matrice doivent avoir la même taille");
			}
		}
	}

	public static void display(int[][] mat) {
		for (int[] lines : mat) {
			for (int item : lines) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat1 = null;
		int[][] mat2 = null;

		boolean ok = true;
		do {
			try {
				mat1 = readMatrix();
				mat2 = readMatrix();
			} catch (CustomException e) {
				System.err.println("[" + e.getMessage() + "]");
				ok = false;
			}
		} while (!ok);

		int[][] prod = null;
		try {
			prod = multiply(mat1, mat2);
			display(prod);
		} catch (CustomException e) {
			System.err.println("[" + e.getMessage() + "]");
		}

	}
}


