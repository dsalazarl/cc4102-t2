# Tarea 2 - Diseño y Análisis de Algoritmos

Implementación de Algoritmo de caminos mínimos
Variantes del algoritmo de Dijkstra

##### Detalles proyecto según paquete:

- package graph:
Dentro de este paquete estan algunas estructuras para la
creacion de grafos, tenemos la clase que representa el grafo "Graph",
"GraphGenerator" para la creacion de grafos, "Pair" para crear clases.

- package priority_queue:
Aqui tenemos la interfaz PriorityQueue que denota un contrato
que deben establecer PQClassicHeap (heap binario) y PQFibonacciHeap, esto es para que ambos
satisfagan en el paquete Dijkstra la clase DijkstraPriorityQueue para encontrar caminos minimos.
Ambos PQClassicHeap y PQFibonacciHeap son las estructuras usadas que implementan sus heaps correspondientes

- package dijkstra:
Aqui encontramos dos implementaciones dijkstra bajo la clase abstracta AbstractDijkstra:
DijkstraArray que implementa los caminos minimos usando un arreglo desordenado
y DijkstraPriorityQueue que lo implementa para una cola de prioridad, dada la cola esto es 
Fibonacci o HeapBinario

- package Main:
En MainDijkstraArray se utiliza para experimentar y probar resultados para el algoritmo con un arreglo y los Main homonimos de distintas estructuras para sus respectivas estructuras


##### Versión de Java ocupada
Java 10.0.2

##### Flag para ejecutar sobre estructuras enormes
VM options: -Xmx7g (Run configurations)

##### IDE Ocupado
IntelliJ