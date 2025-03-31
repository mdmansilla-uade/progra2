package tp3;

import java.util.*;
import tp2.imple.*;
import tp3.utils.Utils;

public class Main {
    public static void main(String[] args) {        

        System.out.println("1. Prueba vaciar pila:");
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println("Pila original: " + pila);
        Utils.vaciarPila(pila);
        System.out.println("Pila despues de vaciar: " + pila);
        System.out.println("Esta vacia? " + pila.isEmpty() + "\n");
        
        System.out.println("2. Prueba buscar en cola:");
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(1);
        cola.offer(2);
        cola.offer(3);
        System.out.println("Cola: " + cola);
        System.out.println("Contiene el 2? " + Utils.encontrarEnCola(cola, 2));
        System.out.println("Contiene el 5? " + Utils.encontrarEnCola(cola, 5) + "\n");
        
        System.out.println("3. Prueba elementos con prioridad:");
        ColaPrioridad colaPrioridad = new ColaPrioridad();
        colaPrioridad.inicializarCola();
        colaPrioridad.acolarPrioridad(1, 1);
        colaPrioridad.acolarPrioridad(2, 2);
        colaPrioridad.acolarPrioridad(3, 1);
        colaPrioridad.acolarPrioridad(4, 2);
        System.out.println("Elementos con prioridad 1: " + Utils.elementosConPrioridad(colaPrioridad, 1));
        System.out.println("Elementos con prioridad 2: " + Utils.elementosConPrioridad(colaPrioridad, 2) + "\n");
        
        System.out.println("4. Prueba elementos comunes:");
        Set<Integer> conjunto1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> conjunto2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);
        System.out.println("Elementos comunes: " + Utils.elementosComunes(conjunto1, conjunto2) + "\n");
        
        System.out.println("5. Prueba cola a diccionario:");
        Queue<Integer> cola2 = new LinkedList<>();
        cola2.offer(10);
        cola2.offer(20);
        cola2.offer(30);
        System.out.println("Cola original: " + cola2);
        Map<Integer, Integer> diccionario = Utils.colaToDiccionario(cola2);
        System.out.println("Diccionario resultante: " + diccionario + "\n");
        
        System.out.println("6. Prueba cola prioridad a diccionario multiple:");
        ColaPrioridad colaPrioridad2 = new ColaPrioridad();
        colaPrioridad2.inicializarCola();
        colaPrioridad2.acolarPrioridad(100, 1);
        colaPrioridad2.acolarPrioridad(200, 2);
        colaPrioridad2.acolarPrioridad(300, 1);
        DiccionarioMultiple diccionarioMultiple = Utils.colaPrioridadToDiccionarioMultiple(colaPrioridad2);
        System.out.println("Diccionario multiple resultante:");
        
        System.out.print("Elementos con prioridad 1: [");
        Conjunto c1 = (Conjunto) diccionarioMultiple.recuperar(1);
        while (!c1.conjuntoVacio()) {
            System.out.print(c1.elegir());
            c1.sacar(c1.elegir());
            if (!c1.conjuntoVacio()) System.out.print(", ");
        }
        System.out.println("]");
        
        System.out.print("Elementos con prioridad 2: [");
        Conjunto c2 = (Conjunto) diccionarioMultiple.recuperar(2);
        while (!c2.conjuntoVacio()) {
            System.out.print(c2.elegir());
            c2.sacar(c2.elegir());
            if (!c2.conjuntoVacio()) System.out.print(", ");
        }
        System.out.println("]");
    }
}