package tp6;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 - Arbol n-ario");
        
        ArbolNArio arbol = new ArbolNArio();
        
        NodoNArio n1 = new NodoNArio(1);
        NodoNArio n2 = new NodoNArio(2);
        NodoNArio n3 = new NodoNArio(3);
        NodoNArio n4 = new NodoNArio(4);
        NodoNArio n5 = new NodoNArio(5);
        NodoNArio n6 = new NodoNArio(6);
        NodoNArio n7 = new NodoNArio(7);
        NodoNArio n8 = new NodoNArio(8);
        
        arbol.setRaiz(n1);
        n1.agregarHijo(n2);
        n1.agregarHijo(n3);
        n1.agregarHijo(n4);
        n2.agregarHijo(n5);
        n2.agregarHijo(n6);
        n6.agregarHijo(n8);
        n4.agregarHijo(n7);
        
        System.out.println("\nProfundidades de los nodos:");
        arbol.mostrarProfundidades();
        
        System.out.println("\nProfundidad del arbol: " + arbol.getProfundidadArbol());
        
        arbol.generarArregloPadres();
        arbol.mostrarArregloPadres();
        
        System.out.println("\n2 - Arbol AVL");
        ArbolAVL avl = new ArbolAVL();
        int[] valoresAVL = {15, 20, 8, 7, 17, 23, 2, 9, 12, 6, 4, 13, 1};
        
        for (int valor : valoresAVL) {
            avl.insertar(valor);
        }
        
        System.out.println("\n3 - Arbol B de orden 3");
        ArbolB arbolB = new ArbolB();
        int[] valoresB = {10, 20, 5, 6, 15, 30, 25};
        
        for (int valor : valoresB) {
            arbolB.insertar(valor);
        }
    }
}
