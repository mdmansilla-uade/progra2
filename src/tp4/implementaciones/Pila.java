package tp4.implementaciones;

import tp4.interfaces.PilaTDA;

public class Pila implements PilaTDA {
    Nodo primero;
    
    public void inicializarPila() {
        primero = null;
    }
    
    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = primero;
        primero = nuevo;
    }
    
    public void desapilar() {
        primero = primero.sig;
    }
    
    public int tope() {
        return primero.info;
    }
    
    public boolean pilaVacia() {
        return primero == null;
    }
} 