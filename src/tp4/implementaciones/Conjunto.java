package tp4.implementaciones;

import tp4.interfaces.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
    Nodo primero;
    
    public void inicializarConjunto() {
        primero = null;
    }
    
    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = primero;
            primero = nuevo;
        }
    }
    
    public void sacar(int x) {
        if (primero != null) {
            if (primero.info == x) {
                primero = primero.sig;
            } else {
                Nodo aux = primero;
                while (aux.sig != null && aux.sig.info != x) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }
    
    public int elegir() {
        return primero.info;
    }
    
    public boolean conjuntoVacio() {
        return primero == null;
    }
    
    public boolean pertenece(int x) {
        Nodo aux = primero;
        while (aux != null && aux.info != x) {
            aux = aux.sig;
        }
        return aux != null;
    }
} 