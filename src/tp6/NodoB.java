package tp6;

public class NodoB {
    private int[] claves;
    private NodoB[] hijos;
    private int numClaves;
    private boolean esHoja;
    
    public NodoB() {
        claves = new int[3];
        hijos = new NodoB[4];
        numClaves = 0;
        esHoja = true;
    }
    
    public boolean insertar(int valor) {
        int i = numClaves - 1;
        
        if (esHoja) {
            while (i >= 0 && claves[i] > valor) {
                claves[i + 1] = claves[i];
                i--;
            }
            claves[i + 1] = valor;
            numClaves++;
            return numClaves == 3;
        }
        
        while (i >= 0 && claves[i] > valor) {
            i--;
        }
        i++;
        
        if (hijos[i].insertar(valor)) {
            return dividirHijo(i, hijos[i]);
        }
        return false;
    }
    
    public boolean dividirHijo(int i, NodoB hijo) {
        NodoB nuevoNodo = new NodoB();
        nuevoNodo.esHoja = hijo.esHoja;
        nuevoNodo.numClaves = 1;
        
        nuevoNodo.claves[0] = hijo.claves[2];
        
        if (!hijo.esHoja) {
            nuevoNodo.hijos[0] = hijo.hijos[2];
            nuevoNodo.hijos[1] = hijo.hijos[3];
        }
        
        hijo.numClaves = 1;
        
        for (int j = numClaves; j >= i + 1; j--) {
            hijos[j + 1] = hijos[j];
        }
        
        hijos[i + 1] = nuevoNodo;
        
        for (int j = numClaves - 1; j >= i; j--) {
            claves[j + 1] = claves[j];
        }
        
        claves[i] = hijo.claves[1];
        numClaves++;
        
        return numClaves == 3;
    }
    
    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < numClaves; i++) {
            System.out.print(claves[i]);
            if (i < numClaves - 1) System.out.print("|");
        }
        System.out.print("]");
        
        if (!esHoja) {
            System.out.println();
            for (int i = 0; i <= numClaves; i++) {
                if (hijos[i] != null) {
                    System.out.print("  ");
                    hijos[i].mostrar();
                }
            }
        }
    }
    
    public int[] getClaves() { return claves; }
    public NodoB[] getHijos() { return hijos; }
    public int getNumClaves() { return numClaves; }
    public boolean isEsHoja() { return esHoja; }
    public void setEsHoja(boolean esHoja) { this.esHoja = esHoja; }
} 