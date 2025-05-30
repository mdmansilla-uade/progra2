package tp6;

public class NodoAVL {
    private int valor;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;
    
    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
    
    public int getValor() {
        return valor;
    }
    
    public NodoAVL getIzquierdo() {
        return izquierdo;
    }
    
    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    public NodoAVL getDerecho() {
        return derecho;
    }
    
    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }
} 