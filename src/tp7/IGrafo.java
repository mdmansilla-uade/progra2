package tp7;

public interface IGrafo {
    void agregarArista(int origen, int destino);
    void eliminarArista(int origen, int destino);
    boolean existeArista(int origen, int destino);
    void mostrar();
} 