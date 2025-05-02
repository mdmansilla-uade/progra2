package tp4.interfaces;

public interface ConjuntoTDA {
    void inicializarConjunto();
    void agregar(int x);
    void sacar(int x);
    int elegir();
    boolean conjuntoVacio();
    boolean pertenece(int x);
} 