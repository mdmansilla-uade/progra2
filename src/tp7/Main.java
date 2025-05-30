package tp7;

public class Main {
    public static void main(String[] args) {       

        System.out.println("a. GRAFO DIRIGIDO - Red social de seguidores");
        System.out.println("- Las aristas tienen direccion (origen -> destino)");
        System.out.println("- Si A sigue a B, B no necesariamente sigue a A");
        System.out.println("- Ejemplo: Red social donde los usuarios pueden seguirse");
        System.out.println("Representación del grafo:");
        GrafoDirigido redSocial = new GrafoDirigido(4);
        redSocial.agregarArista(0, 1);
        redSocial.agregarArista(1, 2);
        redSocial.agregarArista(2, 3);
        redSocial.agregarArista(1, 3);
        redSocial.mostrar();

        System.out.println("\nb. GRAFO NO DIRIGIDO - Red de amigos");
        System.out.println("- Las aristas no tienen direccion");
        System.out.println("- Si A es amigo de B, B es amigo de A");
        System.out.println("- Ejemplo: Red social de amistades mutuas");
        System.out.println("Representacion del grafo:");
        GrafoNoDirigido redAmigos = new GrafoNoDirigido(4);
        redAmigos.agregarArista(0, 1);
        redAmigos.agregarArista(1, 2);
        redAmigos.agregarArista(2, 3);
        redAmigos.mostrar();

        System.out.println("\nc. GRAFO ROTULADO - Red de ciudades");
        System.out.println("- Las aristas tienen un valor o peso asociado");
        System.out.println("- Puede ser dirigido o no dirigido");
        System.out.println("- Ejemplo: Mapa con distancias entre ciudades");
        System.out.println("Representación del grafo:");
        GrafoRotulado redCiudades = new GrafoRotulado(4);
        redCiudades.agregarArista(0, 1, 100);
        redCiudades.agregarArista(1, 2, 150); 
        redCiudades.agregarArista(2, 3, 200); 
        redCiudades.mostrar();

        System.out.println("\nd. GRAFO CONEXO - Red eléctrica");
        System.out.println("- Existe un camino entre cualquier par de vertices");
        System.out.println("- Todos los nodos estan conectados");
        System.out.println("- Ejemplo: Red electrica donde todas las subestaciones estan conectadas");
        System.out.println("Representación del grafo:");
        GrafoConexo redElectrica = new GrafoConexo(4);
        redElectrica.agregarArista(0, 1);
        redElectrica.agregarArista(1, 2);
        redElectrica.agregarArista(2, 3);
        redElectrica.agregarArista(3, 0);
        redElectrica.mostrar();

        System.out.println("\n3 - Recorrido DFS del grafo dado:");
        GrafoDFS grafo = new GrafoDFS(7);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(0, 5);
        grafo.agregarArista(0, 6);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(5, 4);
        System.out.println("Recorrido DFS comenzando desde el vertice 0:");
        System.out.println(grafo.dfs(0));
    }
}