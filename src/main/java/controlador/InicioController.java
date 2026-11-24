package controlador;

import modelo.DatosProyecto;
import vista.PantallaInicio;
import vista.PantallaPrincipal;

public class InicioController {

    private final PantallaInicio vistaInicio;
    private final DatosProyecto modelo;

    public InicioController(PantallaInicio vistaInicio, DatosProyecto modelo) {
        this.vistaInicio = vistaInicio;
        this.modelo = modelo;

        this.vistaInicio.getBtnIngresar().addActionListener(e -> abrirPantallaPrincipal());
    }

    private void abrirPantallaPrincipal() {
        PantallaPrincipal vistaPrincipal = new PantallaPrincipal();
        new PrincipalController(vistaPrincipal, modelo);
        vistaPrincipal.setVisible(true);
        vistaInicio.dispose(); // Cierra la pantalla de inicio
    }
}