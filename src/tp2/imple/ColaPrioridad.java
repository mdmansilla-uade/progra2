package tp2.imple;

import tp2.inter.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

	class Elemento {
		int valor;
		int prioridad;
	}
	Elemento[] arr;
	int indice;
	

	@Override
	public void inicializarCola() {
		arr = new Elemento[100];
		// Inicializar cada elemento del array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Elemento();
		}
		indice = 0;
	}

	@Override
	public void acolarPrioridad(int dato, int prio) {
		// Mover elementos mayores a la derecha
		int i = indice - 1;
		while (i >= 0 && arr[i].prioridad < prio) {
			arr[i + 1] = arr[i];
			i--;
		}
		
		// Insertar el nuevo elemento
		arr[i + 1] = new Elemento();
		arr[i + 1].valor = dato;
		arr[i + 1].prioridad = prio;
		indice++;
	}

	@Override
	public void desacolar() {
		indice--;
	}

	@Override
	public int primero() {
		return arr[indice - 1].valor;
	}

	@Override
	public int prioridad() {
		return arr[indice - 1].prioridad;
	}

	@Override
	public boolean colaVacia() {
		return (indice == 0);
	}

}
