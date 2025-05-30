package tp6;

import java.util.ArrayList;
import java.util.List;

public class NodoNArio {
    private int valor;
    private NodoNArio padre;
    private List<NodoNArio> hijos;
    
    public NodoNArio(int valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
        this.padre = null;
    }
    
    public void agregarHijo(NodoNArio hijo) {
        hijo.padre = this;
        this.hijos.add(hijo);
    }
    
    public int getValor() {
        return valor;
    }
    
    public NodoNArio getPadre() {
        return padre;
    }
    
    public List<NodoNArio> getHijos() {
        return hijos;
    }
} 