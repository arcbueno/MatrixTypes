package testes;

import java.util.Scanner;

public class idMatriz {

	static int l = 0;
	static int c = 0;
	static int mat[][];
	static Scanner scan = new Scanner(System.in);
	static Scanner scan2 = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Digite o número de linhas da Matriz:");
		l = scan.nextInt();
		System.out.println("Digite o número de colunas da Matriz:");
		c = scan.nextInt();

		mat = new int[l][c];

		populaMatriz();
		imprimeMatriz(mat);
		identificaMatriz(mat);
	}

	private static void imprimeMatriz(int[][] mat) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void populaMatriz() {
		int lin = 0;
		int col = 0;
		while (true) {
			System.out.println("Insira uma linha da Matriz ('Q' para terminar):");
			String e = scan2.nextLine();

			if (e.equals("Q") || e.equals("q")) {
				return;
			}
			String elementos[] = e.split(" ");
			// System.out.println(elementos[1]);

			for (String elemento : elementos) {
				int elementoInteiro = Integer.parseInt(elemento);
				mat[lin][col] = elementoInteiro;
				col++;
			}
			col = 0;
			lin++;
		}
	}

	public static void identificaMatriz(int[][] mat) {
		boolean triangular_sup = false;
		boolean triangular_inf = false;

		triangular_sup = seMatrizDiagonalSuperior();
		triangular_inf = seMatrizDiagonalInferior();

		// System.out.println("ENTROU EM IDENTIFICA MATRIZ");

		if (seMatrizNula()) {
			System.out.print("A matriz é nula. ");
		}
		if (seMatrizLinha()) {
			System.out.print("A matriz é linha. ");
		}
		if (seMatrizColuna()) {
			System.out.print("A matriz é coluna. ");
		}
		if (seMatrizQuadrada()) {
			System.out.print("A matriz é quadrada. ");
		}

		if (triangular_sup && triangular_inf) {
			if (seMatrizIdentidade()) {
				System.out.print("A matriz é uma matriz identidade. ");
			}
		} else if (triangular_sup) {
			System.out.print("A matriz é triangular superior. ");
		} else if (triangular_inf) {
			System.out.print("A matriz é triangular inferior. ");
		}

		if (seMatrizSimetrica()) {
			System.out.print("A matriz é simétrica. ");
		}

		// Verificação de Matriz Identidade (if mat[i][i]==0)
		// Verificação de Matriz Simétrica (mat[i][j]==mat[j][i])

	}

	private static boolean seMatrizSimetrica() {
		for (int i = 0; i < l; i++) { // Verificação de Matriz Simetrica
			for (int j = 0; j < c; j++) {
				if (mat[i][j] != mat[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean seMatrizIdentidade() {
		for (int i = 0; i < l; i++) { // Verificação de Matriz Identidade
			for (int j = 0; j < c; j++) {
				if (i == j) {
					if (mat[i][j] != 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean seMatrizDiagonalInferior() {
		for (int i = 0; i < l; i++) { // Verificação de Diagonal Inferior
			for (int j = 0; j < c; j++) {
				if (i < j) {
					if (mat[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean seMatrizDiagonalSuperior() {
		for (int i = 0; i < l; i++) { // Verificação de Diagonal Superior
			for (int j = 0; j < c; j++) {
				if (j < i) {
					if (mat[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean seMatrizQuadrada() {
		if (l == c) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean seMatrizLinha() {
		if (l == 1) {
			// System.out.print("A matriz é uma matriz linha. ");
			return true;
		} else
			return false;
	}

	private static boolean seMatrizColuna() {
		if (c == 1) {
			// System.out.print("A matriz é uma matriz coluna. ");
			return true;
		} else
			return false;
	}

	private static boolean seMatrizNula() {
		for (int i = 0; i < l; i++) { // Verificação de Nulidade
			for (int j = 0; j < c; j++) {
				if (mat[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
