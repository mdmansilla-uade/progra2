package tp2.imple;

import tp2.inter.ConjuntoTDA;
import tp2.inter.DiccionarioSimpleTDA;
public class DiccionarioSimple implements DiccionarioSimpleTDA {

	class Elemento{
		int clave,valor;
	}
	
	private Elemento[] arr;
	private int indice;
	int cant;
	
	@Override
	public void inicializarDiccionario() {
		arr = new Elemento [100];
		cant = 0;
	}
	
	private int clave2Indice(int cl) {
		int pos = indice - 1;
		while (pos >= 0 && arr[pos].clave!=cl) {
			pos--;
		}
		return pos ;
	}
	
	@Override
	public void agregar(int clave, int valor) {
		int pos = clave2Indice(clave);
		if (pos == -1) {
			pos = cant;
			arr[pos] = new Elemento();
			arr[pos].clave = clave;
			cant++;
		}
		arr[pos].valor = valor;
	}

	@Override
	public void eliminar(int clave) {
		int pos = clave2Indice(clave);
		if (pos != -1) {// la clave existe
			arr[pos] = arr[indice-1]; //ToDo (tener cuidado ya que estamos igualando referencias)
			// arr[indice-1] = null;
			/*arr[pos].clave = arr[indice-1].clave;
			 * arr[pos].valor = arr[indice-1].valor;
			 */
			arr[indice-1] = null; //posible
			indice--;
		}

	}

	@Override
	public int recuperar(int clave) { //muy sencillo
		int pos = clave2Indice(clave);
		return arr[pos].valor;

	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		
		// Agregar todas las claves existentes al conjunto
		for (int i = 0; i < cant; i++) {
			c.agregar(arr[i].clave);
		}
		
		return c;
	}

}
