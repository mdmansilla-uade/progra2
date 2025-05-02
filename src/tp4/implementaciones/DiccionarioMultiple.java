package tp4.implementaciones;

import tp4.interfaces.DiccionarioMultipleTDA;
import tp4.interfaces.ConjuntoTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
    NodoMultiple primero;
    
    public void inicializarDiccionario() {
        primero = null;
    }
    
    public void agregar(int clave, int valor) {
        NodoMultiple nodo = primero;
        while (nodo != null && nodo.clave != clave) {
            nodo = nodo.sig;
        }
        
        if (nodo == null) {
            nodo = new NodoMultiple();
            nodo.clave = clave;
            nodo.valores = new Conjunto();
            nodo.valores.inicializarConjunto();
            nodo.sig = primero;
            primero = nodo;
        }
        nodo.valores.agregar(valor);
    }
    
    public void eliminar(int clave) {
        if (primero != null) {
            if (primero.clave == clave) {
                primero = primero.sig;
            } else {
                NodoMultiple aux = primero;
                while (aux.sig != null && aux.sig.clave != clave) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }
    
    public void eliminarValor(int clave, int valor) {
        NodoMultiple nodo = primero;
        while (nodo != null && nodo.clave != clave) {
            nodo = nodo.sig;
        }
        
        if (nodo != null) {
            nodo.valores.sacar(valor);
            if (nodo.valores.conjuntoVacio()) {
                eliminar(clave);
            }
        }
    }
    
    public ConjuntoTDA recuperar(int clave) {
        NodoMultiple aux = primero;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        return aux.valores;
    }
    
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        NodoMultiple aux = primero;
        while (aux != null) {
            claves.agregar(aux.clave);
            aux = aux.sig;
        }
        return claves;
    }
} 