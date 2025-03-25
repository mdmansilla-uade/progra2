package tp2.inter;

public interface ColaPrioridadTDA {
	void inicializarCola();
	void acolarPrioridad(int dato, int prioridad); 
	void desacolar(); 
	int primero(); 
	int prioridad();
	boolean colaVacia(); 
}
