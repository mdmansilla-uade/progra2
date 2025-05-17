package tp5.implementaciones;

public class ABBDinámica implements ABBTDA{
	
	public class NodoABB {
		int info; //devolvera el nro almacenado en el nodo
		ABBTDA hijoIzq;
		ABBTDA hijoDer;

	}
	
	private NodoABB a; //raiz del árbol
	
	@Override
	public void incializarABB() {
		a = null;	
	}

	@Override
	public int raiz() {
		return a.info;
	}

	@Override
	public ABBTDA hijoIzq() {
		return a.hijoIzq;
	}

	@Override
	public ABBTDA hijoDer() {
		return a.hijoDer;
	}

	@Override
	public boolean arbolVacio() {
		return (a == null); //si la raíz esta vacía no hay árbol 
	}
	
	@Override
	public void agregarElem(int x) {
		if(a == null) { //si el árbol esta vacio
			a = new NodoABB();
			a.info = x;
			//comienzo con el izquierdo
			a.hijoIzq = new ABBDinámica();
			a.hijoIzq.incializarABB();
			//termino con el derecho
			a.hijoDer = new ABBDinámica();
			a.hijoDer.incializarABB();
		}
		else if (a.info > x) { //RAIZ VS EL NRO A AGREGAR
			a.hijoIzq.agregarElem(x);
		}
		else if(a.info < x) {
			a.hijoDer.agregarElem(x);
		}
		
	}
	
	private int mayor(ABBTDA a) {
		if(a.hijoDer().arbolVacio()) {
			return a.raiz();
		}
		else
			return mayor(a.hijoDer());
	}
	
	private int menor(ABBTDA a) {
		if(a.hijoIzq().arbolVacio()) {
			return a.raiz();
		}
		else
			return menor(a.hijoIzq());
	}
	
	@Override
	public void eliminarElem(int x) {
		//PRIMER CASO: es una hoja sin hijos
		if(a != null) {
			if(a.info == x && a.hijoIzq.arbolVacio() && a.hijoDer.arbolVacio() ) {
				a = null;
			}
		}
		else if (a.info == x && ! a.hijoIzq.arbolVacio()) {
			int mayor = mayor(a.hijoIzq);
			a.info = mayor;
			//reemplazamos con el mayor de los menores
			a.hijoIzq.eliminarElem(mayor);
		}
		else if (a.info == x && !a.hijoDer.arbolVacio()) {
			int menor = menor(a.hijoDer);
			a.info = menor;
			//reemplazamos con el menor de los menores
			a.hijoDer.eliminarElem(menor);
		}
		else if(a.info < x) {
			//seguimos buscando por los mayores(derecha)
			a.hijoDer.eliminarElem(x);
		}else {
			a.hijoIzq.eliminarElem(x);
			//seguimos buscando por los menores (izquierda)
		}
	}
}