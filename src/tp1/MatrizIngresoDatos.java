package tp1;

import java.util.Scanner;

public class MatrizIngresoDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int filas, columnas;
        do {
            System.out.println("Ingrese el número de filas (debe ser positivo):");
            filas = scanner.nextInt();
            if (filas <= 0) {
                System.out.println("Error: El número debe ser positivo");
            }
        } while (filas <= 0);
        
        do {
            System.out.println("Ingrese el número de columnas (debe ser positivo):");
            columnas = scanner.nextInt();
            if (columnas <= 0) {
                System.out.println("Error: El número debe ser positivo");
            }
        } while (columnas <= 0);
        
        int[][] matriz = new int[filas][columnas];
        
        System.out.println("Ingrese los elementos de la matriz (solo positivos):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    System.out.printf("Ingrese el elemento [%d][%d]: ", i, j);
                    matriz[i][j] = scanner.nextInt();
                    if (matriz[i][j] <= 0) {
                        System.out.println("Error: El número debe ser positivo");
                    }
                } while (matriz[i][j] <= 0);
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