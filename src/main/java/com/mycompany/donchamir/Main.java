package com.mycompany.donchamir;

import controlador.InicioController;
import javax.swing.SwingUtilities;
import modelo.DatosProyecto;
import vista.PantallaInicio;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatosProyecto modelo = new DatosProyecto();
            PantallaInicio vistaInicio = new PantallaInicio();
            new InicioController(vistaInicio, modelo);
            vistaInicio.setLocationRelativeTo(null);
            vistaInicio.setVisible(true);
        });
    }
}