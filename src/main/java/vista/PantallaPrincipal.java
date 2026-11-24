package vista;

import java.awt.*;
import javax.swing.*;

public class PantallaPrincipal extends JFrame {

    // Botones del menú principal
    private JButton btnEficiencia;
    private JButton btnComplejidad;
    private JButton btnPvsNP;
    
    // Botones de Grafos
    private JButton btnTopologico;
    private JButton btnTSP;
    private JButton btnPrim;
    private JButton btnKahn;
    private JButton btnKruskal;
    private JButton btnDijkstra;

    // Panel central (área de ejecución)
    private JLabel lblTituloModulo;
    private JTextArea txtDescripcion;
    private JButton btnIngresarDatos;
    private JButton btnPrecompilado;

    public PantallaPrincipal() {
        setTitle("SIDEDAII - Sistema Didáctico de Estructuras de Datos y Algoritmos II");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- ENCABEZADO (Colores EPN) ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(0, 40, 85)); // Azul EPN
        panelSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(200, 16, 46))); // Línea roja EPN
        JLabel lblHeader = new JLabel("  SIDEDAII - Menú de Ejecución de Algoritmos");
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblHeader.setPreferredSize(new Dimension(950, 55));
        panelSuperior.add(lblHeader, BorderLayout.WEST);
        add(panelSuperior, BorderLayout.NORTH);

        // --- MENÚ LATERAL IZQUIERDO ---
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(11, 1, 5, 5));
        panelMenu.setBackground(new Color(235, 240, 245));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMenu.setPreferredSize(new Dimension(260, 500));

        btnEficiencia = crearBotonMenu("1. Eficiencia Algorítmica");
        btnComplejidad = crearBotonMenu("2. Análisis de Complejidad");
        btnPvsNP = crearBotonMenu("3. P - NP - NP Hard - NP Complete");

        JLabel lblGrafos = new JLabel("4. GRAFOS:");
        lblGrafos.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblGrafos.setForeground(new Color(0, 40, 85));

        btnTopologico = crearBotonSubmenu("   4.1. Árbol Topológico");
        btnTSP = crearBotonSubmenu("   4.2. TSP (Viajante)");
        btnPrim = crearBotonSubmenu("   4.3. Algoritmo de Prim");
        btnKahn = crearBotonSubmenu("   4.4. Algoritmo de Kahn");
        btnKruskal = crearBotonSubmenu("   4.5. Algoritmo de Kruskal");
        btnDijkstra = crearBotonSubmenu("   4.6. Algoritmo de Dijkstra");

        panelMenu.add(btnEficiencia);
        panelMenu.add(btnComplejidad);
        panelMenu.add(btnPvsNP);
        panelMenu.add(lblGrafos);
        panelMenu.add(btnTopologico);
        panelMenu.add(btnTSP);
        panelMenu.add(btnPrim);
        panelMenu.add(btnKahn);
        panelMenu.add(btnKruskal);
        panelMenu.add(btnDijkstra);

        add(panelMenu, BorderLayout.WEST);

        // --- PANEL CENTRAL DE EJECUCIÓN ---
        JPanel panelCentro = new JPanel(new BorderLayout(15, 15));
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        lblTituloModulo = new JLabel("Seleccione un tema o algoritmo del menú izquierdo");
        lblTituloModulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTituloModulo.setForeground(new Color(0, 40, 85));

        txtDescripcion = new JTextArea(
            "Bienvenido al Sistema Didáctico de Estructuras de Datos y Algoritmos II.\n\n" +
            "Aquí podrá explorar cada algoritmo ingresando sus propios datos o ejecutando " +
            "un ejercicio precompilado de demostración."
        );
        txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotonesAccion.setBackground(Color.WHITE);

        btnIngresarDatos = new JButton("Ingresar Datos Manualmente");
        btnIngresarDatos.setBackground(new Color(0, 40, 85));
        btnIngresarDatos.setForeground(Color.WHITE);
        btnIngresarDatos.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIngresarDatos.setEnabled(false);

        btnPrecompilado = new JButton("Ejecutar Ejercicio Precompilado");
        btnPrecompilado.setBackground(new Color(200, 16, 46));
        btnPrecompilado.setForeground(Color.WHITE);
        btnPrecompilado.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnPrecompilado.setEnabled(false);

        panelBotonesAccion.add(btnIngresarDatos);
        panelBotonesAccion.add(btnPrecompilado);

        panelCentro.add(lblTituloModulo, BorderLayout.NORTH);
        panelCentro.add(new JScrollPane(txtDescripcion), BorderLayout.CENTER);
        panelCentro.add(panelBotonesAccion, BorderLayout.SOUTH);

        add(panelCentro, BorderLayout.CENTER);
    }

    private JButton crearBotonMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBackground(new Color(0, 40, 85));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setFocusPainted(false);
        return btn;
    }

    private JButton crearBotonSubmenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(0, 40, 85));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btn.setFocusPainted(false);
        return btn;
    }

    // --- GETTERS PARA EL CONTROLADOR (MVC) ---
    public JButton getBtnEficiencia() { return btnEficiencia; }
    public JButton getBtnComplejidad() { return btnComplejidad; }
    public JButton getBtnPvsNP() { return btnPvsNP; }
    public JButton getBtnTopologico() { return btnTopologico; }
    public JButton getBtnTSP() { return btnTSP; }
    public JButton getBtnPrim() { return btnPrim; }
    public JButton getBtnKahn() { return btnKahn; }
    public JButton getBtnKruskal() { return btnKruskal; }
    public JButton getBtnDijkstra() { return btnDijkstra; }
    public JButton getBtnIngresarDatos() { return btnIngresarDatos; }
    public JButton getBtnPrecompilado() { return btnPrecompilado; }

    public void actualizarModulo(String titulo, String descripcion) {
        lblTituloModulo.setText(titulo);
        txtDescripcion.setText(descripcion);
        btnIngresarDatos.setEnabled(true);
        btnPrecompilado.setEnabled(true);
    }
}