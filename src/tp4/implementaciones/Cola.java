package tp4.implementaciones;

import tp4.interfaces.ColaTDA;

public class Cola implements ColaTDA {
    Nodo primero;
    Nodo ultimo;
    
    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }
    
    public void acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;
        
        if (primero == null) {
            primero = nuevo;
        } else {
            ultimo.sig = nuevo;
        }
        ultimo = nuevo;
    }
    
    public void desacolar() {
        primero = primero.sig;
        if (primero == null) {
            ultimo = null;
        }
    }
    
    public int primero() {
        return primero.info;
    }
    
    public boolean colaVacia() {
        return primero == null;
    }
} 