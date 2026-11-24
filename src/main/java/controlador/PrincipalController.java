package controlador;

import javax.swing.JOptionPane;
import modelo.DatosProyecto;
import vista.PantallaPrincipal;

public class PrincipalController {

    private final PantallaPrincipal vista;
    private final DatosProyecto modelo;
    private String moduloActual = "";

    public PrincipalController(PantallaPrincipal vista, DatosProyecto modelo) {
        this.vista = vista;
        this.modelo = modelo;
        inicializarEventos();
    }

    private void inicializarEventos() {
        vista.getBtnEficiencia().addActionListener(e -> seleccionar("1. Eficiencia Algorítmica", "Eficiencia"));
        vista.getBtnComplejidad().addActionListener(e -> seleccionar("2. Análisis de Complejidad", "Complejidad"));
        vista.getBtnPvsNP().addActionListener(e -> seleccionar("3. P - NP - NP Hard - NP Complete", "PvsNP"));

        vista.getBtnTopologico().addActionListener(e -> seleccionar("4.1. Árbol Topológico", "Topologico"));
        vista.getBtnTSP().addActionListener(e -> seleccionar("4.2. TSP (Viajante)", "TSP"));
        vista.getBtnPrim().addActionListener(e -> seleccionar("4.3. Algoritmo de Prim", "Prim"));
        vista.getBtnKahn().addActionListener(e -> seleccionar("4.4. Algoritmo de Kahn", "Kahn"));
        vista.getBtnKruskal().addActionListener(e -> seleccionar("4.5. Algoritmo de Kruskal", "Kruskal"));
        vista.getBtnDijkstra().addActionListener(e -> seleccionar("4.6. Algoritmo de Dijkstra", "Dijkstra"));

        vista.getBtnIngresarDatos().addActionListener(e ->
            JOptionPane.showMessageDialog(vista, "Ingreso manual de datos para: " + moduloActual + "\n(Próximo avance)")
        );

        vista.getBtnPrecompilado().addActionListener(e ->
            JOptionPane.showMessageDialog(vista, "Ejecución de ejercicio precompilado para: " + moduloActual + "\n(Próximo avance)")
        );
    }

    private void seleccionar(String titulo, String clave) {
        this.moduloActual = titulo;
        vista.actualizarModulo(titulo, modelo.getDescripcion(clave));
    }
}