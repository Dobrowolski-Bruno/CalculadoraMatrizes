import java.util.Scanner;

public class CalculadoraMatrizes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== CALCULADORA DE MATRIZES =====");
            System.out.println("1 - Somar duas matrizes");
            System.out.println("2 - Subtrair duas matrizes");
            System.out.println("3 - Multiplicar duas matrizes");
            System.out.println("4 - Transposta de uma matriz");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    somar(sc);
                    break;
                case 2:
                    subtrair(sc);
                    break;
                case 3:
                    multiplicar(sc);
                    break;
                case 4:
                    transposta(sc);
                    break;
                case 0:
                    System.out.println("Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    static double[][] lerMatriz(Scanner sc, int linhas, int colunas, String nome) {
        double[][] m = new double[linhas][colunas];
        System.out.println("Digite os valores da matriz " + nome + ":");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                m[i][j] = sc.nextDouble();
            }
        }
        return m;
    }

    static void mostrarMatriz(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%8.2f", m[i][j]);
            }
            System.out.println();
        }
    }

    static void somar(Scanner sc) {
        System.out.print("Numero de linhas: ");
        int lin = sc.nextInt();
        System.out.print("Numero de colunas: ");
        int col = sc.nextInt();

        double[][] a = lerMatriz(sc, lin, col, "A");
        double[][] b = lerMatriz(sc, lin, col, "B");
        double[][] resultado = new double[lin][col];

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                resultado[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("\nResultado da soma:");
        mostrarMatriz(resultado);
    }

    static void subtrair(Scanner sc) {
        System.out.print("Numero de linhas: ");
        int lin = sc.nextInt();
        System.out.print("Numero de colunas: ");
        int col = sc.nextInt();

        double[][] a = lerMatriz(sc, lin, col, "A");
        double[][] b = lerMatriz(sc, lin, col, "B");
        double[][] resultado = new double[lin][col];

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                resultado[i][j] = a[i][j] - b[i][j];
            }
        }

        System.out.println("\nResultado da subtracao:");
        mostrarMatriz(resultado);
    }

    static void multiplicar(Scanner sc) {
        System.out.println("Para multiplicar, o numero de colunas da matriz A");
        System.out.println("precisa ser igual ao numero de linhas da matriz B.");

        System.out.print("Linhas de A: ");
        int linA = sc.nextInt();
        System.out.print("Colunas de A (= linhas de B): ");
        int colA = sc.nextInt();
        System.out.print("Colunas de B: ");
        int colB = sc.nextInt();

        double[][] a = lerMatriz(sc, linA, colA, "A");
        double[][] b = lerMatriz(sc, colA, colB, "B");
        double[][] resultado = new double[linA][colB];

        for (int i = 0; i < linA; i++) {
            for (int j = 0; j < colB; j++) {
                double soma = 0;
                for (int k = 0; k < colA; k++) {
                    soma = soma + a[i][k] * b[k][j];
                }
                resultado[i][j] = soma;
            }
        }

        System.out.println("\nResultado da multiplicacao:");
        mostrarMatriz(resultado);
    }

    static void transposta(Scanner sc) {
        System.out.print("Numero de linhas: ");
        int lin = sc.nextInt();
        System.out.print("Numero de colunas: ");
        int col = sc.nextInt();

        double[][] a = lerMatriz(sc, lin, col, "A");
        double[][] t = new double[col][lin];

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                t[j][i] = a[i][j];
            }
        }

        System.out.println("\nMatriz transposta:");
        mostrarMatriz(t);
    }
}
