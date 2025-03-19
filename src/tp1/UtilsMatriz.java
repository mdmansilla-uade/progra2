package tp1;

public class UtilsMatriz {
    public static void invertirFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length / 2; j++) {
                int temp = matriz[i][j];
                matriz[i][j] = matriz[i][matriz[i].length - 1 - j];
                matriz[i][matriz[i].length - 1 - j] = temp;
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
} 