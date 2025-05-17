package tp5.implementaciones;

import java.util.ArrayList;
import java.util.List;

public class Recorridos {
	
	//preOrder : raíz -> izq -> der
	public void preOrder(ABBTDA a) {
		if(!a.arbolVacio()) {
			System.out.println(a.raiz()); //raíz
			preOrder(a.hijoIzq()); //subárbol izq
			preOrder(a.hijoDer()); //subárbol der
		}
	}
	
	//inOrder: izq -> raiz -> der
	public void inOrder(ABBTDA a) {
		if(a.arbolVacio()) {
			inOrder(a.hijoIzq());
			System.out.println(a.raiz());
			inOrder(a.hijoDer());
		}
	}
	
	//postOrder: izq -> der -> raiz
	public void postOrder(ABBTDA a) {
		if(!a.arbolVacio()) {
			postOrder(a.hijoIzq());
			postOrder(a.hijoDer());
			System.out.println(a.raiz());
		}
	}

	public static List<Character> preOrden(ABBTDA arbol) {
		List<Character> resultado = new ArrayList<>();
		if (!arbol.arbolVacio()) {
			// Raíz
			resultado.add((char)arbol.raiz());
			// Subárbol izquierdo
			resultado.addAll(preOrden(arbol.hijoIzq()));
			// Subárbol derecho
			resultado.addAll(preOrden(arbol.hijoDer()));
		}
		return resultado;
	}

	public static List<Character> postOrden(ABBTDA arbol) {
		List<Character> resultado = new ArrayList<>();
		if (!arbol.arbolVacio()) {
			// Subárbol izquierdo
			resultado.addAll(postOrden(arbol.hijoIzq()));
			// Subárbol derecho
			resultado.addAll(postOrden(arbol.hijoDer()));
			// Raíz
			resultado.add((char)arbol.raiz());
		}
		return resultado;
	}

	public static List<Character> inOrden(ABBTDA arbol) {
		List<Character> resultado = new ArrayList<>();
		if (!arbol.arbolVacio()) {
			// Subárbol izquierdo
			resultado.addAll(inOrden(arbol.hijoIzq()));
			// Raíz
			resultado.add((char)arbol.raiz());
			// Subárbol derecho
			resultado.addAll(inOrden(arbol.hijoDer()));
		}
		return resultado;
	}

}
