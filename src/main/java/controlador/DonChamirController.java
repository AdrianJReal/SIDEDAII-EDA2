package controlador;

import com.mycompany.donchamir.DonChamir;
import vista.DonChamirView;

public class DonChamirController {
    private DonChamirView vista;
    private DonChamir modelo;

    public DonChamirController(DonChamirView vista, DonChamir modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.addEjecutarListener(e -> ejecutarAccion());
    }

    private void ejecutarAccion() {
        String opcion = vista.getOpcionSeleccionada();

        if (opcion == null || opcion.equals("Selecciona una opcion")) {
            vista.mostrarMensaje("Por favor, selecciona una operación válida.");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(vista.getTextoN());

            if (n <= 0) {
                vista.mostrarMensaje("Ingresa un número mayor que cero.");
                return;
            }

            if (n > 1_000_000) {
                vista.mostrarMensaje("Para esta práctica, utiliza un valor de hasta 1,000,000.");
                return;
            }

        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Debes ingresar un número entero válido.");
            return;
        }

        // Delegar los cálculos al Modelo según la opción
        if (opcion.equals("Numeros aleatorios y suma")) {
            DonChamir.ResultadoAleatorios res = modelo.procesarAleatorios(n);
            vista.setResultado(res.texto);
        } else if (opcion.equals("Comparar FOR y Gauss")) {
            String resultadoComparacion = modelo.compararMetodos(n);
            vista.setResultado(resultadoComparacion);
        }
    }
}