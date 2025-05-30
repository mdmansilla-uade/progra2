package tp7;

import java.util.*;

public class GrafoConexo implements IGrafo {
    private List<List<Integer>> listaAdyacencia;
    private int numVertices;

    public GrafoConexo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    @Override
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            listaAdyacencia.get(origen).add(destino);
            listaAdyacencia.get(destino).add(origen);
        }
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            listaAdyacencia.get(origen).remove(Integer.valueOf(destino));
            listaAdyacencia.get(destino).remove(Integer.valueOf(origen));
        }
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return listaAdyacencia.get(origen).contains(destino);
        }
        return false;
    }

    public boolean esConexo() {
        if (numVertices == 0) return true;
        
        boolean[] visitado = new boolean[numVertices];
        dfs(0, visitado);
        
        for (boolean v : visitado) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int vertice, boolean[] visitado) {
        visitado[vertice] = true;
        for (int adyacente : listaAdyacencia.get(vertice)) {
            if (!visitado[adyacente]) {
                dfs(adyacente, visitado);
            }
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Lista de Adyacencia (Grafo Conexo):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            System.out.println(listaAdyacencia.get(i));
        }
        System.out.println("Es conexo: " + esConexo());
    }
} 