package tp5.implementaciones;

public interface ABBTDA {
	void incializarABB();
	void agregarElem(int x); //árbol inicializado
	void eliminarElem(int x); //árbol inicializado y no vacío
	int raiz(); //árbol inicializado y no vacío
	ABBTDA hijoIzq(); //árbol inicializado y no vacío
	ABBTDA hijoDer(); //árbol inicializado y no vacío
	boolean arbolVacio();//árbol inicializado
}
