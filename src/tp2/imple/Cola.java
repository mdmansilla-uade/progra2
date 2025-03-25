package tp2.imple;

import tp2.inter.ColaTDA;

public class Cola implements ColaTDA {

	int[] arr;
	int indice;
	
	@Override
	public void inicializarCola() {
		arr = new int[100];
		indice = 0;
	}

	@Override
	public void acolar(int dato) {
		arr[indice] = dato;
		indice++;
	}

	@Override
	public void desacolar() {
		for (int i = 0; i < indice - 1; i++) {
			arr[i] = arr[i + 1];
		}
		indice--;
	}

	@Override
	public boolean colaVacia() {
		return (indice == 0);
	}

	@Override
	public int primero() {
		return arr[0];
	}

}
