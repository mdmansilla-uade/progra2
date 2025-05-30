package tp7;

public class GrafoRotulado implements IGrafo {
    private int[][] matrizPesos;
    private int numVertices;

    public GrafoRotulado(int numVertices) {
        this.numVertices = numVertices;
        matrizPesos = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizPesos[i][j] = -1;
            }
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizPesos[origen][destino] = peso;
            matrizPesos[destino][origen] = peso;
        }
    }

    @Override
    public void agregarArista(int origen, int destino) {
        agregarArista(origen, destino, 1);
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizPesos[origen][destino] = -1;
            matrizPesos[destino][origen] = -1;
        }
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizPesos[origen][destino] != -1;
        }
        return false;
    }

    @Override
    public void mostrar() {
        System.out.println("Matriz de Pesos:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }
} 