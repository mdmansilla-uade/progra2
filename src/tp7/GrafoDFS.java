package tp7;

import java.util.*;

public class GrafoDFS {
    private int numVertices;
    private List<List<Integer>> listaAdyacencia;
    private boolean[] visitado;
    private List<Integer> recorridoDFS;

    public GrafoDFS(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
        visitado = new boolean[numVertices];
        recorridoDFS = new ArrayList<>();
    }

    public void agregarArista(int origen, int destino) {
        listaAdyacencia.get(origen).add(destino);
    }

    private void dfsUtil(int vertice) {
        visitado[vertice] = true;
        recorridoDFS.add(vertice);

        for (int adyacente : listaAdyacencia.get(vertice)) {
            if (!visitado[adyacente]) {
                dfsUtil(adyacente);
            }
        }
    }

    public List<Integer> dfs(int inicio) {
        Arrays.fill(visitado, false);
        recorridoDFS.clear();
        dfsUtil(inicio);
        return recorridoDFS;
    }
} 