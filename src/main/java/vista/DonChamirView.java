package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DonChamirView extends JFrame {

    private JComboBox<String> menu;
    private JTextField txtN;
    private JTextArea areaResultados;
    private JButton btnEjecutar;

    public DonChamirView() {
        setTitle("DonChamir - EDAII Lab 01 (MVC)");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana sin apagar el menú principal
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("PROGRAMA DE SUMATORIAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        menu = new JComboBox<>(new String[]{
            "Selecciona una opcion",
            "Numeros aleatorios y suma",
            "Comparar FOR y Gauss"
        });

        JLabel etiquetaN = new JLabel("Cantidad o valor de n:");
        txtN = new JTextField(10);
        btnEjecutar = new JButton("Ejecutar");

        JPanel panelOpciones = new JPanel(new FlowLayout());
        panelOpciones.add(new JLabel("Operacion:"));
        panelOpciones.add(menu);
        panelOpciones.add(etiquetaN);
        panelOpciones.add(txtN);
        panelOpciones.add(btnEjecutar);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaResultados.setText(
            "Bienvenido al módulo DonChamir.\n\n"
            + "Selecciona una operacion del menu,\n"
            + "ingresa el valor solicitado y presiona Ejecutar."
        );

        JScrollPane scroll = new JScrollPane(areaResultados);
        scroll.setPreferredSize(new java.awt.Dimension(600, 300));

        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(panelOpciones, BorderLayout.CENTER);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // Getters para que el controlador interactúe con los componentes
    public String getOpcionSeleccionada() {
        return (String) menu.getSelectedItem();
    }

    public String getTextoN() {
        return txtN.getText().trim();
    }

    public void setResultado(String texto) {
        areaResultados.setText(texto);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void addEjecutarListener(ActionListener listener) {
        btnEjecutar.addActionListener(listener);
    }
}