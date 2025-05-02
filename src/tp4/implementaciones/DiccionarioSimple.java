package tp4.implementaciones;

import tp4.interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
    NodoClave primero;
    
    public void inicializarDiccionario() {
        primero = null;
    }
    
    public void agregar(int clave, int valor) {
        if (!claveExiste(clave)) {
            NodoClave nuevo = new NodoClave();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.sig = primero;
            primero = nuevo;
        } else {
            NodoClave aux = primero;
            while (aux != null && aux.clave != clave) {
                aux = aux.sig;
            }
            aux.valor = valor;
        }
    }
    
    public void eliminar(int clave) {
        if (primero != null) {
            if (primero.clave == clave) {
                primero = primero.sig;
            } else {
                NodoClave aux = primero;
                while (aux.sig != null && aux.sig.clave != clave) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }
    
    public int recuperar(int clave) {
        NodoClave aux = primero;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        return aux.valor;
    }
    
    public boolean claveExiste(int clave) {
        NodoClave aux = primero;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        return aux != null;
    }
} 