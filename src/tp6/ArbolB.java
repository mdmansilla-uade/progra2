package tp6;

public class ArbolB {
    private NodoB raiz;
    
    public ArbolB() {
        raiz = new NodoB();
    }
    
    public void insertar(int valor) {
        System.out.println("\nInsertando " + valor);
        
        NodoB r = raiz;
        if (r.getNumClaves() == 2) {
            NodoB nuevaRaiz = new NodoB();
            raiz = nuevaRaiz;
            nuevaRaiz.setEsHoja(false);
            nuevaRaiz.getHijos()[0] = r;
            nuevaRaiz.dividirHijo(0, r);
            insertarNoLleno(nuevaRaiz, valor);
        } else {
            insertarNoLleno(r, valor);
        }
        
        mostrarArbol();
    }
    
    private void insertarNoLleno(NodoB nodo, int valor) {
        if (nodo.isEsHoja()) {
            nodo.insertar(valor);
            return;
        }
        
        int i = nodo.getNumClaves() - 1;
        while (i >= 0 && nodo.getClaves()[i] > valor) {
            i--;
        }
        i++;
        
        NodoB hijo = nodo.getHijos()[i];
        if (hijo == null) {
            hijo = new NodoB();
            nodo.getHijos()[i] = hijo;
        }
        
        if (hijo.getNumClaves() == 2) {
            nodo.dividirHijo(i, hijo);
            if (valor > nodo.getClaves()[i]) {
                i++;
            }
            hijo = nodo.getHijos()[i];
        }
        
        insertarNoLleno(hijo, valor);
    }
    
    public void mostrarArbol() {
        System.out.println("Estado actual del arbol B:");
        if (raiz != null) {
            raiz.mostrar();
            System.out.println("\n");
        }
    }
} 