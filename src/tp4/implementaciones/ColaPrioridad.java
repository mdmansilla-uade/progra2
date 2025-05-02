package tp4.implementaciones;

import tp4.interfaces.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
    NodoPrioridad primero;
    
    public void inicializarCola() {
        primero = null;
    }
    
    public void acolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = prioridad;
        
        if (primero == null || prioridad > primero.prioridad) {
            nuevo.sig = primero;
            primero = nuevo;
        } else {
            NodoPrioridad aux = primero;
            while (aux.sig != null && aux.sig.prioridad >= prioridad) {
                aux = aux.sig;
            }
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }
    
    public void desacolar() {
        primero = primero.sig;
    }
    
    public int primero() {
        return primero.info;
    }
    
    public int prioridad() {
        return primero.prioridad;
    }
    
    public boolean colaVacia() {
        return primero == null;
    }
} 