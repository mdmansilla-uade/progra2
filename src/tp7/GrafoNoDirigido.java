package tp7;

import java.util.*;

public class GrafoNoDirigido implements IGrafo {
    private List<List<Integer>> listaAdyacencia;
    private int numVertices;

    public GrafoNoDirigido(int numVertices) {
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
            listaAdyacencia.get(destino).add(origen); // Por ser no dirigido
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

    @Override
    public void mostrar() {
        System.out.println("Lista de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            System.out.println(listaAdyacencia.get(i));
        }
    }
} 