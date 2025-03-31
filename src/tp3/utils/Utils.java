package tp3.utils;

import java.util.*;
import tp2.imple.*;

public class Utils {
    /**
     * 1. Desapilar todos los elementos de una pila
     * Complejidad: O(n) donde n es el número de elementos en la pila
     */
    public static void vaciarPila(Stack<Integer> pila) {
        while (!pila.isEmpty()) {
            pila.pop();
        }
    }
    
    /**
     * 2. Encontrar un elemento en una cola
     * Complejidad: O(n) donde n es el número de elementos en la cola
     */
    public static boolean encontrarEnCola(Queue<Integer> cola, Integer elemento) {
        Queue<Integer> colaAux = new LinkedList<>();
        boolean encontrado = false;
        
        while (!cola.isEmpty()) {
            Integer actual = cola.poll();
            if (actual.equals(elemento)) {
                encontrado = true;
            }
            colaAux.offer(actual);
        }
        
        // Restaurar la cola original
        while (!colaAux.isEmpty()) {
            cola.offer(colaAux.poll());
        }
        
        return encontrado;
    }
    
    /**
     * 3. Encontrar elementos con prioridad x en cola con prioridad
     * Complejidad: O(n) donde n es el número de elementos en la cola
     */
    public static List<Integer> elementosConPrioridad(ColaPrioridad cola, int prioridad) {
        List<Integer> elementos = new ArrayList<>();
        ColaPrioridad colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        
        while (!cola.colaVacia()) {
            Integer elemento = (Integer) cola.primero();
            int prioridadActual = cola.prioridad();
            cola.desacolar();
            if (prioridadActual == prioridad) {
                elementos.add(elemento);
            }
            colaAux.acolarPrioridad(elemento, prioridadActual);
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            Integer elemento = (Integer) colaAux.primero();
            int prioridadActual = colaAux.prioridad();
            colaAux.desacolar();
            cola.acolarPrioridad(elemento, prioridadActual);
        }
        
        return elementos;
    }
    
    /**
     * 4. Encontrar elementos comunes entre dos conjuntos
     * Complejidad: O(n + m) donde n y m son los tamaños de los conjuntos
     */
    public static Set<Integer> elementosComunes(Set<Integer> c1, Set<Integer> c2) {
        Set<Integer> comunes = new HashSet<>();
        for (Integer elemento : c1) {
            if (c2.contains(elemento)) {
                comunes.add(elemento);
            }
        }
        return comunes;
    }
    
    /**
     * 5. Cola a diccionario simple con posiciones
     * Complejidad: O(n) donde n es el número de elementos en la cola
     */
    public static Map<Integer, Integer> colaToDiccionario(Queue<Integer> cola) {
        Map<Integer, Integer> diccionario = new HashMap<>();
        Queue<Integer> colaAux = new LinkedList<>();
        int posicion = 0;
        
        while (!cola.isEmpty()) {
            Integer elemento = cola.poll();
            diccionario.put(elemento, posicion++);
            colaAux.offer(elemento);
        }
        
        // Restaurar la cola original
        while (!colaAux.isEmpty()) {
            cola.offer(colaAux.poll());
        }
        
        return diccionario;
    }
    
    /**
     * 6. Cola con prioridad a diccionario múltiple
     * Complejidad: O(n) donde n es el número de elementos en la cola
     */
    public static DiccionarioMultiple colaPrioridadToDiccionarioMultiple(ColaPrioridad cola) {
        DiccionarioMultiple diccionario = new DiccionarioMultiple();
        diccionario.inicializarDiccionario();
        ColaPrioridad colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        
        while (!cola.colaVacia()) {
            Integer elemento = (Integer) cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();
            diccionario.agregar(prioridad, elemento);
            colaAux.acolarPrioridad(elemento, prioridad);
        }
        
        // Restaurar la cola original
        while (!colaAux.colaVacia()) {
            Integer elemento = (Integer) colaAux.primero();
            int prioridad = colaAux.prioridad();
            colaAux.desacolar();
            cola.acolarPrioridad(elemento, prioridad);
        }
        
        return diccionario;
    }
} 