package tp4;

import java.util.LinkedList;
import tp4.implementaciones.*;
import tp4.interfaces.*;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("\n3. Prueba desapilar en lista:");
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        LinkedList<Integer> lista = Utils.desapilarEnLista(pila);
        System.out.println("Lista resultante: " + lista);
        
        System.out.println("\n4. Prueba encontrar en cola:");
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        System.out.println("Contiene el 2? " + Utils.encontrarEnCola(cola, 2));
        System.out.println("Contiene el 5? " + Utils.encontrarEnCola(cola, 5));
        
        System.out.println("5. Prueba elementos con prioridad:");
        ColaPrioridadTDA colaPrioridad = new ColaPrioridad();
        colaPrioridad.inicializarCola();
        colaPrioridad.acolarPrioridad(1, 1);
        colaPrioridad.acolarPrioridad(2, 2);
        colaPrioridad.acolarPrioridad(3, 1);
        ConjuntoTDA elementosPrioridad1 = Utils.elementosConPrioridad(colaPrioridad, 1);
        System.out.println("Elementos con prioridad 1:");
        while (!elementosPrioridad1.conjuntoVacio()) {
            int elemento = elementosPrioridad1.elegir();
            System.out.println(elemento);
            elementosPrioridad1.sacar(elemento);
        }
        System.out.println();
        
        System.out.println("\n6. Prueba elementos comunes:");
        ConjuntoTDA conjunto1 = new Conjunto();
        ConjuntoTDA conjunto2 = new Conjunto();
        conjunto1.inicializarConjunto();
        conjunto2.inicializarConjunto();
        conjunto1.agregar(1);
        conjunto1.agregar(2);
        conjunto1.agregar(3);
        conjunto2.agregar(2);
        conjunto2.agregar(3);
        conjunto2.agregar(4);
        ConjuntoTDA comunes = Utils.elementosComunes(conjunto1, conjunto2);
        System.out.println("Elementos comunes:");
        while (!comunes.conjuntoVacio()) {
            int elemento = comunes.elegir();
            System.out.println(elemento);
            comunes.sacar(elemento);
        }
        System.out.println();
        
        System.out.println("\n7. Prueba cola a diccionario:");
        ColaTDA cola2 = new Cola();
        cola2.inicializarCola();
        cola2.acolar(10);
        cola2.acolar(20);
        cola2.acolar(30);
        DiccionarioSimpleTDA diccionario = Utils.colaToDiccionario(cola2);
        System.out.println("Posicion del 10: " + diccionario.recuperar(10));
        System.out.println("Posicion del 20: " + diccionario.recuperar(20));
        System.out.println("Posicion del 30: " + diccionario.recuperar(30));
        
        System.out.println("8. Prueba cola prioridad a diccionario multiple:");
        ColaPrioridadTDA colaPrioridad2 = new ColaPrioridad();
        colaPrioridad2.inicializarCola();
        colaPrioridad2.acolarPrioridad(100, 1);
        colaPrioridad2.acolarPrioridad(200, 2);
        colaPrioridad2.acolarPrioridad(300, 1);
        DiccionarioMultipleTDA diccionarioMultiple = Utils.colaPrioridadToDiccionarioMultiple(colaPrioridad2);
        
        System.out.println("Elementos con prioridad 1:");
        ConjuntoTDA valores1 = diccionarioMultiple.recuperar(1);
        while (!valores1.conjuntoVacio()) {
            int elemento = valores1.elegir();
            System.out.println(elemento);
            valores1.sacar(elemento);
        }
        
        System.out.println("Elementos con prioridad 2:");
        ConjuntoTDA valores2 = diccionarioMultiple.recuperar(2);
        while (!valores2.conjuntoVacio()) {
            int elemento = valores2.elegir();
            System.out.println(elemento);
            valores2.sacar(elemento);
        }
        
        System.out.println("\n9. Complejidad temporal de los metodos:");
        System.out.println("desapilarEnLista: O(n) - Recorre todos los elementos una vez");
        System.out.println("encontrarEnCola: O(n) - Recorre todos los elementos una vez"); 
        System.out.println("elementosConPrioridad: O(n) - Recorre todos los elementos una vez");
        System.out.println("elementosComunes: O(n*m) - Por cada elemento de c1 busca en c2");
        System.out.println("colaToDiccionario: O(n) - Recorre todos los elementos una vez");
        System.out.println("colaPrioridadToDiccionarioMultiple: O(n) - Recorre todos los elementos una vez");
    }
} 