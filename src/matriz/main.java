package matriz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	static int a[][];
	static int l = 0;
	static int c = 0;
	static Scanner sc = new Scanner(System.in);
    static boolean start;
    static boolean valido;

	public static void main(String[] args) {

        start = true;

        do{
            try{
                menuInicial();
                System.out.println("Obrigado por usar nosso sistema :)");
                valido = false;
                start = false;
            } catch (Exception e){
                System.out.println(" \n" + e);

            }
        }while (start);

	}

	public static void menuPrincipal() {
		System.out.println(" ");
		System.out.println("----- Seja bem-vindo! -----");
		System.out.println("Escolha a opcao que voce deseja:\n 1- Identificar Matriz\n 2- Imprimir Matriz");
        System.out.println(" 3- Voltar ao menu inicial");
        System.out.println("Caso deseja sair do sistema, digite qualquer outra tecla");
	}

	public static void menuInicial(){
        valido = true;

        System.out.println();
        System.out.println("-------- Preencha a Matriz antes de acessar as opcoes: -------");
        System.out.println(" ");
        System.out.print("Insira o numero de linhas ->");
        l = sc.nextInt();
        System.out.print("Insira o numero de colunas ->");
        c = sc.nextInt();

        if(l != 0 && c != 0){
            System.out.println(" ");
            System.out.println("    *Sua matriz possui "+ l +" linhas e " + c + " colunas !*");
            System.out.println(" ");
            a = new int[l][c];
            //System.out.println(a.length);


            for (int i = 0; i < l; i++) {

                for (int j = 0; j < c; j++) {
                    System.out.print("Insira o valor na posicao " + i + " da matriz -> ");
                    a[i][j] = sc.nextInt();
                }
            }

            do {
                menuPrincipal();

                switch (validar()) {
                    case 1:

                        identificarMatriz(a);
                        System.out.println(" ");
                        break;
                    case 2:
                        imprimirMatriz(a);

                        break;
                    case 3:
                        menuInicial();

                    default:
                        return;

                }


            } while (valido);
        } else{
            System.out.println("Por favor, digite numeros validos");
        }
    }

	public static int validar() {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		try {
			x = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return x;
	}

	public static void identificarMatriz(int[][] a) {
		Scanner sc = new Scanner(System.in);
		boolean triangular_sup = false;
		boolean triangular_inf = false;

		triangular_sup = seMatrizDiagonalSuperior();
		triangular_inf = seMatrizDiagonalInferior();

		// System.out.println("ENTROU EM IDENTIFICA MATRIZ");

		if (seMatrizNula()) {
			System.out.print("A matriz eh nula. ");
		}
		else if (seMatrizLinha()) {
			System.out.print("A matriz eh uma matriz linha. ");
		}
        else if (seMatrizColuna()) {
			System.out.print("A matriz eh uma matriz coluna. ");
		}
		else {

            if (seMatrizQuadrada()) {
                System.out.print("A matriz eh uma matriz quadrada. ");

                if (triangular_sup && triangular_inf) {
                    if (seMatrizIdentidade()) {
                        System.out.print("A matriz eh uma matriz identidade. ");
                    }
                } else if (triangular_sup) {
                    System.out.print("A matriz eh uma matriz triangular superior. ");
                } else if (triangular_inf) {
                    System.out.print("A matriz eh uma matriz triangular inferior. ");
                }
                if (seMatrizSimetrica()) {
                    System.out.print("A matriz eh uma matriz simetrica. ");
                }
            }
            else {
                System.out.println("A matriz nao eh especial para ser classificada");
            }

        }

		// Verificacao de Matriz Identidade (if mat[i][i]==0)
		// Verificacao de Matriz Simetrica (mat[i][j]==mat[j][i])
	}

	private static boolean seMatrizSimetrica() {
		for (int i = 0; i < l; i++) { // Verificacao de Matriz Simetrica
			for (int j = 0; j < c; j++) {
				if (a[i][j] != a[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean seMatrizIdentidade() {
		for (int i = 0; i < l; i++) { // Verificacao de Matriz Identidade
			for (int j = 0; j < c; j++) {
				if (i == j) {
					if (a[i][j] != 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean seMatrizDiagonalInferior() {
		for (int i = 0; i < l; i++) { // Verificacao de Diagonal Inferior
			for (int j = 0; j < c; j++) {
				if (i < j) {
					if (a[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean seMatrizDiagonalSuperior() {
		for (int i = 0; i < l; i++) { // Verificacao de Diagonal Superior
			for (int j = 0; j < c; j++) {
				if (j < i) {
					if (a[i][j] != 0) {
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
		if (l == 1 && c > 0) {
			// System.out.print("A matriz e uma matriz linha. ");
			return true;
		} else
			return false;
	}

	private static boolean seMatrizColuna() {
		if (c == 1 && l > 0) {
			// System.out.print("A matriz e uma matriz coluna. ");
			return true;
		} else
			return false;
	}

	private static boolean seMatrizNula() { // OK
		for (int i = 0; i < l; i++) { // Verificacao de Nulidade
			for (int j = 0; j < c; j++) {
				if (a[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	

	public static void imprimirMatriz(int[][] a) {

		for (int i = 0; i < l ; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();

		}
	}
}