package tp4.interfaces;

public interface ColaPrioridadTDA {
    void inicializarCola();
    void acolarPrioridad(int x, int prioridad);
    void desacolar();
    int primero();
    int prioridad();
    boolean colaVacia();
} 