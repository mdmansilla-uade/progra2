package tp2.imple;

import tp2.inter.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

	int[] arr;
	int cant;
	@Override
	public void inicializarConjunto() {
		arr = new int [100];
		cant = 0;

	}

	@Override
	public void agregar(int x) {
		if(!this.pertenece(x)) {
			arr[cant] = x;
			cant++;
		}
	}

	@Override
	public void sacar(int x) {
		int i = 0;// constante
		while(i<cant && arr[i] != x) {
			i++; //constante
		}// lineal
		if(i != cant) { //x pertenece al conjunto lo encontramos
			arr[i] = arr[cant-1];
			cant--;
		}//constante
	}// constante + lineal + constante = (nos quedamos con el peor) --> lineal

	@Override
	public int elegir() {
		return arr[cant-1];
	}

	@Override
	public boolean pertenece(int x) {
		int i = 0;
		while(i<cant && arr[i] != x) {
			i++;
		}
		return (i != cant);
	}

	@Override
	public boolean conjuntoVacio() {
		return cant == 0;
	}

}
