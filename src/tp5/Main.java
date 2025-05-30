package tp5;

import java.util.ArrayList;
import java.util.List;
import tp5.implementaciones.ABBDinámica;
import tp5.implementaciones.ABBTDA;
import tp5.implementaciones.Recorridos;

public class Main {

    public static void main(String[] args) {
        System.out.println("1 - Arbol Binario");
        ABBTDA arbol = new ABBDinámica();

        arbol.agregarElem(7);
        arbol.agregarElem(5);
        arbol.agregarElem(13);
        arbol.agregarElem(3);
        arbol.agregarElem(12);
        arbol.agregarElem(15);

        System.out.println("\na) Altura de cada nodo y del arbol:");
        mostrarAlturas(arbol);

        System.out.println("\nb) Estructura del arbol:");
        mostrarEstructura(arbol, false);

        System.out.println("\nc) Hojas del arbol:");
        mostrarHojas(arbol);

        System.out.println("\nd) Nodos internos del arbol:");
        mostrarNodosInternos(arbol);

        System.out.println("\n2 - Recorridos del arbol de caracteres");
        ABBTDA arbolChar = new ABBDinámica();

        arbolChar.agregarElem('N');
        arbolChar.agregarElem('D');
        arbolChar.agregarElem('P');
        arbolChar.agregarElem('B');
        arbolChar.agregarElem('J');
        arbolChar.agregarElem('F');
        arbolChar.agregarElem('G');
        arbolChar.agregarElem('X');
        arbolChar.agregarElem('R');
        arbolChar.agregarElem('Z');

        System.out.println("\na) Recorrido Pre-Orden:");
        List<Character> preOrden = Recorridos.preOrden(arbolChar);
        System.out.println(preOrden);

        System.out.println("\nb) Recorrido Post-Orden:");
        List<Character> postOrden = Recorridos.postOrden(arbolChar);
        System.out.println(postOrden);

        System.out.println("\nc) Recorrido In-Orden:");
        List<Character> inOrden = Recorridos.inOrden(arbolChar);
        System.out.println(inOrden);

        System.out.println("\nd) Estructura del arbol:");
        mostrarEstructura(arbolChar, true);

        System.out.println("\n3) Suma de todos los valores:");
        int suma = sumarValores(arbol);
        System.out.println("La suma total es: " + suma);

        System.out.println("\n4) Valores en niveles impares:");
        imprimirNivelesImpares(arbol);

        System.out.println("\n5) Mayor y menor valor:");
        int[] mayorMenor = obtenerMayorMenor(arbol);
        System.out.println("Menor valor: " + mayorMenor[0]);
        System.out.println("Mayor valor: " + mayorMenor[1]);

        System.out.println("\n6) Prueba de insercion en ABB:");
        ABBTDA arbolPrueba = new ABBDinámica();
        arbolPrueba.agregarElem(10);
        System.out.println("Insertando 10 como raiz");
        mostrarEstructura(arbolPrueba, false);

        arbolPrueba.agregarElem(5);
        System.out.println("\nInsertando 5 (menor que raiz -> izquierda)");
        mostrarEstructura(arbolPrueba, false);

        arbolPrueba.agregarElem(15);
        System.out.println("\nInsertando 15 (mayor que raiz -> derecha)");
        mostrarEstructura(arbolPrueba, false);

        System.out.println("\n7) Prueba de eliminacion:");
        System.out.println("arbol original:");
        mostrarEstructura(arbol, false);

        System.out.println("\nEliminando el valor 5:");
        arbol.eliminarElem(5);
        mostrarEstructura(arbol, false);
    }

    private static void mostrarAlturas(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            List<Integer> elementos = obtenerElementos(arbol);

            for (Integer elem : elementos) {
                int altura = calcularAltura(arbol, elem);
                System.out.println("Nodo " + elem + ": altura = " + altura);
            }

            System.out.println("\nAltura total del arbol: " + calcularAlturaTotal(arbol));
        }
    }

    private static void mostrarEstructura(ABBTDA arbol, boolean esArbolChar) {
        if (!arbol.arbolVacio()) {
            String valor = esArbolChar ? 
                String.valueOf((char) arbol.raiz()) : 
                String.valueOf(arbol.raiz());
            System.out.println("Raiz: " + valor);
            mostrarHijos(arbol, valor, esArbolChar);
        }
    }

    private static void mostrarHijos(ABBTDA arbol, String valorPadre, boolean esArbolChar) {
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return;
        }

        if (!arbol.hijoIzq().arbolVacio()) {
            String valorIzq = esArbolChar ? 
                String.valueOf((char) arbol.hijoIzq().raiz()) : 
                String.valueOf(arbol.hijoIzq().raiz());
            System.out.println("Hijo izquierdo de " + valorPadre + ": " + valorIzq);
            mostrarHijos(arbol.hijoIzq(), valorIzq, esArbolChar);
        }

        if (!arbol.hijoDer().arbolVacio()) {
            String valorDer = esArbolChar ? 
                String.valueOf((char) arbol.hijoDer().raiz()) : 
                String.valueOf(arbol.hijoDer().raiz());
            System.out.println("Hijo derecho de " + valorPadre + ": " + valorDer);
            mostrarHijos(arbol.hijoDer(), valorDer, esArbolChar);
        }
    }

    private static void mostrarHojas(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            List<Integer> hojas = obtenerHojas(arbol);
            System.out.println("Las hojas son: " + hojas);
        }
    }

    private static void mostrarNodosInternos(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            List<Integer> nodosInternos = obtenerNodosInternos(arbol);
            System.out.println("Los nodos internos son: " + nodosInternos);
        }
    }

    private static List<Integer> obtenerElementos(ABBTDA arbol) {
        List<Integer> elementos = new ArrayList<>();
        if (!arbol.arbolVacio()) {
            elementos.addAll(obtenerElementos(arbol.hijoIzq()));
            elementos.add(arbol.raiz());
            elementos.addAll(obtenerElementos(arbol.hijoDer()));
        }
        return elementos;
    }

    private static int calcularAltura(ABBTDA arbol, int elemento) {
        if (arbol.arbolVacio()) {
            return -1;
        }

        if (arbol.raiz() == elemento) {
            return Math.max(calcularAlturaTotal(arbol.hijoIzq()),
                    calcularAlturaTotal(arbol.hijoDer())) + 1;
        }

        if (elemento < arbol.raiz()) {
            return calcularAltura(arbol.hijoIzq(), elemento);
        } else {
            return calcularAltura(arbol.hijoDer(), elemento);
        }
    }

    private static int calcularAlturaTotal(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        return Math.max(calcularAlturaTotal(arbol.hijoIzq()),
                calcularAlturaTotal(arbol.hijoDer())) + 1;
    }

    private static List<Integer> obtenerHojas(ABBTDA arbol) {
        List<Integer> hojas = new ArrayList<>();
        if (!arbol.arbolVacio()) {
            if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
                hojas.add(arbol.raiz());
            } else {
                hojas.addAll(obtenerHojas(arbol.hijoIzq()));
                hojas.addAll(obtenerHojas(arbol.hijoDer()));
            }
        }
        return hojas;
    }

    private static List<Integer> obtenerNodosInternos(ABBTDA arbol) {
        List<Integer> nodosInternos = new ArrayList<>();
        if (!arbol.arbolVacio()) {
            if (!arbol.hijoIzq().arbolVacio() || !arbol.hijoDer().arbolVacio()) {
                nodosInternos.add(arbol.raiz());
            }
            nodosInternos.addAll(obtenerNodosInternos(arbol.hijoIzq()));
            nodosInternos.addAll(obtenerNodosInternos(arbol.hijoDer()));
        }
        return nodosInternos;
    }

    private static int sumarValores(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz()
                + sumarValores(arbol.hijoIzq())
                + sumarValores(arbol.hijoDer());
    }

    private static void imprimirNivelesImpares(ABBTDA arbol) {
        imprimirNivel(arbol, 1);
    }

    private static void imprimirNivel(ABBTDA arbol, int nivel) {
        if (arbol.arbolVacio()) {
            return;
        }

        if (nivel % 2 == 1) {
            System.out.println("Nivel " + nivel + ": " + arbol.raiz());
        }

        imprimirNivel(arbol.hijoIzq(), nivel + 1);
        imprimirNivel(arbol.hijoDer(), nivel + 1);
    }

    private static int[] obtenerMayorMenor(ABBTDA arbol) {
        int[] resultado = new int[2];
        if (arbol.arbolVacio()) {
            throw new IllegalStateException("arbol vacio");
        }

        ABBTDA actual = arbol;
        while (!actual.hijoIzq().arbolVacio()) {
            actual = actual.hijoIzq();
        }
        resultado[0] = actual.raiz(); // menor

        actual = arbol;
        while (!actual.hijoDer().arbolVacio()) {
            actual = actual.hijoDer();
        }
        resultado[1] = actual.raiz();

        return resultado;
    }
}
