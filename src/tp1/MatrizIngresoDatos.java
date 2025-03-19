package tp1;

import java.util.Scanner;

public class MatrizIngresoDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de filas:");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas:");
        int columnas = scanner.nextInt();
        
        int[][] matriz = new int[filas][columnas];
        
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("Ingrese el elemento [%d][%d]: ", i, j);
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatriz original:");
        UtilsMatriz.imprimirMatriz(matriz);
        
        UtilsMatriz.invertirFilas(matriz);
        
        System.out.println("\nMatriz con filas invertidas:");
        UtilsMatriz.imprimirMatriz(matriz);
        
        scanner.close();
    }
} 