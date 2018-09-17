package testes;

import java.util.Scanner;

public class inserirValores {

	public static void main(String[] args) {
		int[][] a = new int[3][3];
		inserirValor(a);
		imprimaAMatriz(a);

	}

	public static void inserirValor(int[][] a) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length; j++) {
				System.out.print("insira o valor da posição " + i + " -> ");
				a[i][j] = scan.nextInt();
			}
		}
	}

	public static void imprimaAMatriz(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();

		}

	}

}
