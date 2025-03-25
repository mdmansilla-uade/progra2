package tp2.utils;

import tp2.imple.*;
import tp2.inter.*;

public class MetodosTAD {
    
    // 1. Copiar una pila
    public static void copiarPila(PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        
        // Pasamos a auxiliar invirtiendo
        while (!origen.pilaVacia()) {
            aux.apilar(origen.tope());
            origen.desapilar();
        }
        
        // Recuperamos orden original y copiamos
        while (!aux.pilaVacia()) {
            int valor = aux.tope();
            origen.apilar(valor);
            destino.apilar(valor);
            aux.desapilar();
        }
    }
    
    // 2. Verificar si una cola es capicua
    public static boolean esCapicua(ColaTDA cola) {
        if (cola.colaVacia()) return true;
        
        PilaTDA pila = new Pila();
        ColaTDA colaAux = new Cola();
        pila.inicializarPila();
        colaAux.inicializarCola();
        
        // Copiamos la cola y creamos la pila
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            pila.apilar(valor);
            colaAux.acolar(valor);
            cola.desacolar();
        }
        
        // Restauramos la cola original y comparamos
        boolean esCapicua = true;
        while (!colaAux.colaVacia()) {
            if (colaAux.primero() != pila.tope()) {
                esCapicua = false;
            }
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
            pila.desapilar();
        }
        
        return esCapicua;
    }
    
    // 3. Invertir cola usando pilas
    public static void invertirColaConPila(ColaTDA cola) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        
        while (!cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }
        
        while (!pila.pilaVacia()) {
            cola.acolar(pila.tope());
            pila.desapilar();
        }
    }
    
    // 4. Invertir cola sin estructuras auxiliares
    public static void invertirColaSinAuxiliar(ColaTDA cola) {
        if (cola.colaVacia()) return;
        
        int primero = cola.primero();
        cola.desacolar();
        
        if (!cola.colaVacia()) {
            invertirColaSinAuxiliar(cola);
        }
        
        cola.acolar(primero);
    }
    
    // 5. Elementos con misma prioridad
    public static ColaTDA elementosConMismaPrioridad(ColaPrioridadTDA cola, int prioridad) {
        ColaTDA resultado = new Cola();
        ColaPrioridadTDA aux = new ColaPrioridad();
        resultado.inicializarCola();
        aux.inicializarCola();
        
        // Copiamos la cola original a aux para no perderla
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            int prio = cola.prioridad();
            aux.acolarPrioridad(valor, prio);
            cola.desacolar();
        }
        
        // Buscamos elementos con la prioridad deseada
        while (!aux.colaVacia()) {
            if (aux.prioridad() == prioridad) {
                resultado.acolar(aux.primero());
            }
            // Restauramos la cola original
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
        
        return resultado;
    }
    
    // 6. Union de conjuntos
    public static ConjuntoTDA unionConjuntos(ConjuntoTDA conj1, ConjuntoTDA conj2) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();
        
        // Copiamos elementos del primer conjunto
        ConjuntoTDA aux1 = new Conjunto();
        aux1.inicializarConjunto();
        while (!conj1.conjuntoVacio()) {
            int elemento = conj1.elegir();
            resultado.agregar(elemento);
            aux1.agregar(elemento);
            conj1.sacar(elemento);
        }
        
        // Restauramos conj1
        while (!aux1.conjuntoVacio()) {
            int elemento = aux1.elegir();
            conj1.agregar(elemento);
            aux1.sacar(elemento);
        }
        
        // Agregamos elementos del segundo conjunto
        ConjuntoTDA aux2 = new Conjunto();
        aux2.inicializarConjunto();
        while (!conj2.conjuntoVacio()) {
            int elemento = conj2.elegir();
            resultado.agregar(elemento);
            aux2.agregar(elemento);
            conj2.sacar(elemento);
        }
        
        // Restauramos conj2
        while (!aux2.conjuntoVacio()) {
            int elemento = aux2.elegir();
            conj2.agregar(elemento);
            aux2.sacar(elemento);
        }
        
        return resultado;
    }
    
    // 7. Devolver las claves de un diccionario simple
    public static ConjuntoTDA obtenerClaves(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        
        ConjuntoTDA aux = diccionario.claves();
        while (!aux.conjuntoVacio()) {
            int clave = aux.elegir();
            claves.agregar(clave);
            aux.sacar(clave);
        }
        
        return claves;
    }
    
    // 8. Devolver los valores de una clave en diccionario multiple
    public static ConjuntoTDA obtenerValores(DiccionarioMultipleTDA diccionario, int clave) {
        ConjuntoTDA valores = new Conjunto();
        valores.inicializarConjunto();
        
        ConjuntoTDA valoresClave = diccionario.recuperar(clave);
        while (!valoresClave.conjuntoVacio()) {
            int valor = valoresClave.elegir();
            valores.agregar(valor);
            valoresClave.sacar(valor);
        }
        
        return valores;
    }
    
    // Método auxiliar para mostrar conjuntos
    public static void mostrarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new Conjunto();
        aux.inicializarConjunto();
        
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            aux.agregar(elemento);
            conjunto.sacar(elemento);
        }
        
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            conjunto.agregar(elemento);
            aux.sacar(elemento);
        }
        System.out.println();
    }
} 