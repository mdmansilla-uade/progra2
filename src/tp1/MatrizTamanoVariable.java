package tp1;

import java.util.Scanner;

public class MatrizTamanoVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de filas:");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas:");
        int columnas = scanner.nextInt();
        
        int[][] matriz = new int[filas][columnas];
        
        // Llenar la matriz con números de ejemplo
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = i * columnas + j + 1;
            }
        }

        System.out.println("Matriz original:");
        UtilsMatriz.imprimirMatriz(matriz);
        
        UtilsMatriz.invertirFilas(matriz);
        
        System.out.println("\nMatriz con filas invertidas:");
        UtilsMatriz.imprimirMatriz(matriz);
        
        scanner.close();
    }
} 