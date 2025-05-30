package tp7;

public class GrafoDirigido implements IGrafo {
    private boolean[][] matrizAdyacencia;
    private int numVertices;

    public GrafoDirigido(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new boolean[numVertices][numVertices];
    }

    @Override
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = true;
        }
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = false;
        }
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino];
        }
        return false;
    }

    @Override
    public void mostrar() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print((matrizAdyacencia[i][j] ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }
} 