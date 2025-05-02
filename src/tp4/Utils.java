package tp4;

import tp4.implementaciones.*;
import tp4.interfaces.*;
import java.util.LinkedList;

public class Utils {
    public static LinkedList<Integer> desapilarEnLista(PilaTDA pila) {
        LinkedList<Integer> lista = new LinkedList<>();
        while (!pila.pilaVacia()) {
            lista.add(pila.tope());
            pila.desapilar();
        }
        return lista;
    }
    
    public static boolean encontrarEnCola(ColaTDA cola, int elemento) {
        boolean encontrado = false;
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        
        while (!cola.colaVacia()) {
            int actual = cola.primero();
            if (actual == elemento) {
                encontrado = true;
            }
            cola.desacolar();
            colaAux.acolar(actual);
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        
        return encontrado;
    }
    
    public static ConjuntoTDA elementosConPrioridad(ColaPrioridadTDA cola, int prioridad) {
        ConjuntoTDA elementos = new Conjunto();
        elementos.inicializarConjunto();
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            int prioridadActual = cola.prioridad();
            if (prioridadActual == prioridad) {
                elementos.agregar(elemento);
            }
            colaAux.acolarPrioridad(elemento, prioridadActual);
            cola.desacolar();
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            cola.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        
        return elementos;
    }
    
    public static ConjuntoTDA elementosComunes(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA comunes = new Conjunto();
        comunes.inicializarConjunto();
        
        while (!c1.conjuntoVacio()) {
            int elemento = c1.elegir();
            if (c2.pertenece(elemento)) {
                comunes.agregar(elemento);
            }
            c1.sacar(elemento);
        }
        
        return comunes;
    }
    
    public static DiccionarioSimpleTDA colaToDiccionario(ColaTDA cola) {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimple();
        diccionario.inicializarDiccionario();
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        int posicion = 0;
        
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            diccionario.agregar(elemento, posicion++);
            colaAux.acolar(elemento);
            cola.desacolar();
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        
        return diccionario;
    }
    
    public static DiccionarioMultipleTDA colaPrioridadToDiccionarioMultiple(ColaPrioridadTDA cola) {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultiple();
        diccionario.inicializarDiccionario();
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            int prioridad = cola.prioridad();
            diccionario.agregar(prioridad, elemento);
            colaAux.acolarPrioridad(elemento, prioridad);
            cola.desacolar();
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            cola.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
            colaAux.desacolar();
        }
        
        return diccionario;
    }
}