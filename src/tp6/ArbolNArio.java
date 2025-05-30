package tp6;

import java.util.ArrayList;
import java.util.List;

public class ArbolNArio {
    private NodoNArio raiz;
    private List<Integer> padres;
    
    public ArbolNArio() {
        this.padres = new ArrayList<>();
    }
    
    public void setRaiz(NodoNArio raiz) {
        this.raiz = raiz;
    }
    
    public int getProfundidadNodo(NodoNArio nodo) {
        int profundidad = 0;
        NodoNArio actual = nodo;
        
        while (actual.getPadre() != null) {
            profundidad++;
            actual = actual.getPadre();
        }
        
        return profundidad;
    }
    
    public int getProfundidadArbol() {
        return getProfundidadArbolRec(raiz);
    }
    
    private int getProfundidadArbolRec(NodoNArio nodo) {
        if (nodo == null) return -1;
        
        int maxProfundidad = -1;
        for (NodoNArio hijo : nodo.getHijos()) {
            maxProfundidad = Math.max(maxProfundidad, getProfundidadArbolRec(hijo));
        }
        
        return maxProfundidad + 1;
    }
    
    public void mostrarProfundidades() {
        mostrarProfundidadesRec(raiz);
    }
    
    private void mostrarProfundidadesRec(NodoNArio nodo) {
        if (nodo != null) {
            System.out.println("Nodo " + nodo.getValor() + " - Profundidad: " + getProfundidadNodo(nodo));
            for (NodoNArio hijo : nodo.getHijos()) {
                mostrarProfundidadesRec(hijo);
            }
        }
    }
    
    public void generarArregloPadres() {
        generarArregloPadresRec(raiz);
    }
    
    private void generarArregloPadresRec(NodoNArio nodo) {
        if (nodo != null) {
            while (padres.size() < nodo.getValor()) {
                padres.add(null);
            }
            
            if (nodo.getPadre() != null) {
                padres.set(nodo.getValor() - 1, nodo.getPadre().getValor());
            } else {
                padres.set(nodo.getValor() - 1, 0); 
            }
            
            for (NodoNArio hijo : nodo.getHijos()) {
                generarArregloPadresRec(hijo);
            }
        }
    }
    
    public void mostrarArregloPadres() {
        System.out.println("\nArreglo de padres:");
        System.out.print("Indice:  ");
        for (int i = 0; i < padres.size(); i++) {
            System.out.printf("%-4d", i + 1);
        }
        System.out.print("\nPadre:   ");
        for (Integer padre : padres) {
            System.out.printf("%-4d", padre);
        }
        System.out.println();
    }
} 