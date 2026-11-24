package modelo;

public class DatosProyecto {
    public String getDescripcion(String tema) {
        return switch (tema) {
            case "Eficiencia" -> "Módulo de Eficiencia Algorítmica.\nCompara el rendimiento y el trade-off entre tiempo y espacio.";
            case "Complejidad" -> "Módulo de Análisis de Complejidad.\nEvaluación de cotas asintóticas O, Ω y Θ.";
            case "PvsNP" -> "Módulo de Clases de Complejidad.\nP, NP, NP-Hard, NP-Complete y reducciones polinomiales.";
            case "Topologico" -> "Grafo: Árbol Topológico.\nOrdenamiento lineal de vértices en un Grafo Dirigido Acíclico (DAG).";
            case "TSP" -> "Grafo: Problema del Viajante (TSP).\nBúsqueda del recorrido mínimo visitando todos los nodos.";
            case "Prim" -> "Grafo: Algoritmo de Prim.\nConstrucción del Árbol de Expansión Mínima (MST) desde un nodo origen.";
            case "Kahn" -> "Grafo: Algoritmo de Kahn.\nOrdenamiento topológico basado en grados de entrada (indegree).";
            case "Kruskal" -> "Grafo: Algoritmo de Kruskal.\nConstrucción del MST ordenando aristas de menor a mayor peso.";
            case "Dijkstra" -> "Grafo: Algoritmo de Dijkstra.\nCálculo de la ruta más corta desde un origen con pesos no negativos.";
            default -> "Seleccione un algoritmo del menú.";
        };
    }
}