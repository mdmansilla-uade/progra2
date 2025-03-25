package tp2;

import tp2.imple.Cola;
import tp2.imple.ColaPrioridad;
import tp2.imple.Conjunto;
import tp2.imple.DiccionarioMultiple;
import tp2.imple.DiccionarioSimple;
import tp2.imple.Pila;
import tp2.inter.ColaPrioridadTDA;
import tp2.inter.ColaTDA;
import tp2.inter.ConjuntoTDA;
import tp2.inter.DiccionarioMultipleTDA;
import tp2.inter.DiccionarioSimpleTDA;
import tp2.inter.PilaTDA;
import tp2.utils.MetodosTAD;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Prueba copiar pila:");
        probarCopiarPila();
        
        System.out.println("\n2. Prueba cola capicua:");
        probarColaCapicua();
        
        System.out.println("\n3. Prueba invertir cola con pila:");
        probarInvertirColaConPila();
        
        System.out.println("\n4. Prueba invertir cola sin auxiliar:");
        probarInvertirColaSinAuxiliar();
        
        System.out.println("\n5. Prueba elementos misma prioridad:");
        probarElementosMismaPrioridad();
        
        System.out.println("\n6. Prueba union conjuntos:");
        probarUnionConjuntos();
        
        System.out.println("\n7. Prueba obtener claves diccionario simple:");
        probarObtenerClaves();
        
        System.out.println("\n8. Prueba obtener valores diccionario multiple:");
        probarObtenerValores();
    }
    
    private static void probarCopiarPila() {
        PilaTDA original = new Pila();
        PilaTDA copia = new Pila();
        original.inicializarPila();
        copia.inicializarPila();
        
        original.apilar(1);
        original.apilar(2);
        original.apilar(3);
        
        MetodosTAD.copiarPila(original, copia);
        
        System.out.print("Pila original: ");
        while (!original.pilaVacia()) {
            System.out.print(original.tope() + " ");
            original.desapilar();
        }
        System.out.print("\nPila copiada: ");
        while (!copia.pilaVacia()) {
            System.out.print(copia.tope() + " ");
            copia.desapilar();
        }
        System.out.println();
    }
    
    private static void probarColaCapicua() {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(2);
        cola.acolar(1);
        
        System.out.print("Cola: ");
        while (!cola.colaVacia()) {
            System.out.print(cola.primero() + " ");
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        System.out.println("\nEs capicua? " + MetodosTAD.esCapicua(cola));
    }
    
    private static void probarInvertirColaConPila() {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        
        System.out.print("Cola original: ");
        while (!cola.colaVacia()) {
            System.out.print(cola.primero() + " ");
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        
        MetodosTAD.invertirColaConPila(cola);
        
        System.out.print("\nCola invertida: ");
        while (!cola.colaVacia()) {
            System.out.print(cola.primero() + " ");
            cola.desacolar();
        }
        System.out.println();
    }
    
    private static void probarInvertirColaSinAuxiliar() {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        
        System.out.print("Cola original: ");
        while (!cola.colaVacia()) {
            System.out.print(cola.primero() + " ");
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        
        MetodosTAD.invertirColaSinAuxiliar(cola);
        
        System.out.print("\nCola invertida: ");
        while (!cola.colaVacia()) {
            System.out.print(cola.primero() + " ");
            cola.desacolar();
        }
        System.out.println();
    }
    
    private static void probarElementosMismaPrioridad() {
        ColaPrioridadTDA cola = new ColaPrioridad();
        cola.inicializarCola();
        
        cola.acolarPrioridad(10, 1);
        cola.acolarPrioridad(20, 3);
        cola.acolarPrioridad(30, 2);
        cola.acolarPrioridad(40, 1);
        
        System.out.println("Cola con prioridad original:");
        System.out.println("Valor\tPrioridad");
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();
        
        while (!cola.colaVacia()) {
            System.out.println(cola.primero() + "\t" + cola.prioridad());
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        
        while (!aux.colaVacia()) {
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
        
        System.out.println("\nElementos con prioridad 1:");
        ColaTDA resultado = MetodosTAD.elementosConMismaPrioridad(cola, 1);
        
        while (!resultado.colaVacia()) {
            System.out.print(resultado.primero() + " ");
            resultado.desacolar();
        }
         System.out.println("\nElementos con prioridad 2:");
        ColaTDA resultado2 = MetodosTAD.elementosConMismaPrioridad(cola, 2);
        
        while (!resultado2.colaVacia()) {
            System.out.print(resultado2.primero() + " ");
            resultado2.desacolar();
        }
        System.out.println();
    }
    
    private static void probarUnionConjuntos() {
        ConjuntoTDA conj1 = new Conjunto();
        ConjuntoTDA conj2 = new Conjunto();
        conj1.inicializarConjunto();
        conj2.inicializarConjunto();
        
        conj1.agregar(1);
        conj1.agregar(2);
        conj2.agregar(2);
        conj2.agregar(3);
        
        System.out.print("Conjunto 1: ");
        MetodosTAD.mostrarConjunto(conj1);
        System.out.print("Conjunto 2: ");
        MetodosTAD.mostrarConjunto(conj2);
        
        ConjuntoTDA union = MetodosTAD.unionConjuntos(conj1, conj2);
        System.out.print("union: ");
        MetodosTAD.mostrarConjunto(union);
    }
    
    private static void probarObtenerClaves() {
        DiccionarioSimpleTDA dicc = new DiccionarioSimple();
        dicc.inicializarDiccionario();
        
        dicc.agregar(1, 10);
        dicc.agregar(2, 20);
        
        System.out.println("Claves del diccionario simple:");
        MetodosTAD.mostrarConjunto(MetodosTAD.obtenerClaves(dicc));
    }
    
    private static void probarObtenerValores() {
        DiccionarioMultipleTDA dicc = new DiccionarioMultiple();
        dicc.inicializarDiccionario();
        
        dicc.agregar(1, 10);
        dicc.agregar(1, 11);
        dicc.agregar(2, 20);
        
        System.out.println("Valores para la clave 1:");
        MetodosTAD.mostrarConjunto(MetodosTAD.obtenerValores(dicc, 1));
    }
} 