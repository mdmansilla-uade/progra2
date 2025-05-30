package tp6;

public class ArbolAVL {
    private NodoAVL raiz;
    
    public void insertar(int valor) {
        System.out.println("\nInsertando " + valor);
        raiz = insertarRec(raiz, valor);
        mostrarArbol();
    }
    
    private NodoAVL insertarRec(NodoAVL nodo, int valor) {
        if (nodo == null) {
            return new NodoAVL(valor);
        }
        
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        } else {
            return nodo;
        }
        
        nodo.setAltura(1 + Math.max(getAltura(nodo.getIzquierdo()), 
                                   getAltura(nodo.getDerecho())));
        
        int balance = getBalance(nodo);
        
        if (balance > 1 && valor < nodo.getIzquierdo().getValor()) {
            System.out.println("Rotación simple a la derecha");
            return rotacionDerecha(nodo);
        }
        
        if (balance < -1 && valor > nodo.getDerecho().getValor()) {
            System.out.println("Rotación simple a la izquierda");
            return rotacionIzquierda(nodo);
        }
        
        if (balance > 1 && valor > nodo.getIzquierdo().getValor()) {
            System.out.println("Rotación doble izquierda-derecha");
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        
        if (balance < -1 && valor < nodo.getDerecho().getValor()) {
            System.out.println("Rotación doble derecha-izquierda");
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }
        
        return nodo;
    }
    
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();
        
        x.setDerecho(y);
        y.setIzquierdo(T2);
        
        y.setAltura(Math.max(getAltura(y.getIzquierdo()), 
                            getAltura(y.getDerecho())) + 1);
        x.setAltura(Math.max(getAltura(x.getIzquierdo()), 
                            getAltura(x.getDerecho())) + 1);
        
        return x;
    }
    
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T2 = y.getIzquierdo();
        
        y.setIzquierdo(x);
        x.setDerecho(T2);
        
        x.setAltura(Math.max(getAltura(x.getIzquierdo()), 
                            getAltura(x.getDerecho())) + 1);
        y.setAltura(Math.max(getAltura(y.getIzquierdo()), 
                            getAltura(y.getDerecho())) + 1);
        
        return y;
    }
    
    private int getAltura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.getAltura();
    }
    
    private int getBalance(NodoAVL nodo) {
        if (nodo == null) return 0;
        return getAltura(nodo.getIzquierdo()) - getAltura(nodo.getDerecho());
    }
    
    public void mostrarArbol() {
        System.out.println("Estado actual del arbol:");
        mostrarArbolRec(raiz, "", true);
        System.out.println();
    }
    
    private void mostrarArbolRec(NodoAVL nodo, String prefijo, boolean esIzquierdo) {
        if (nodo != null) {
            System.out.println(prefijo + (esIzquierdo ? "+-- " : "+-- ") + nodo.getValor() + 
                             " (h=" + nodo.getAltura() + ")");
            mostrarArbolRec(nodo.getIzquierdo(), prefijo + (esIzquierdo ? "|   " : "    "), true);
            mostrarArbolRec(nodo.getDerecho(), prefijo + (esIzquierdo ? "|   " : "    "), false);
        }
    }
} 