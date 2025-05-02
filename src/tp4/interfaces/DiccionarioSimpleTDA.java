package tp4.interfaces;

public interface DiccionarioSimpleTDA {
    void inicializarDiccionario();
    void agregar(int clave, int valor);
    void eliminar(int clave);
    int recuperar(int clave);
    boolean claveExiste(int clave);
} 