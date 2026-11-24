package com.mycompany.donchamir;


import java.util.Random;

public class DonChamir {

    // Ejercicio 1: Generar números y sumarlos
    public ResultadoAleatorios procesarAleatorios(int n) {
        Random random = new Random();
        int[] numeros = new int[n];
        long suma = 0;

        long inicio = System.nanoTime();
        StringBuilder texto = new StringBuilder();
        texto.append("NUMEROS GENERADOS\n\n");

        for (int i = 0; i < n; i++) {
            numeros[i] = random.nextInt(100) + 1;
            texto.append(numeros[i]).append(" ");

            if ((i + 1) % 10 == 0) {
                texto.append("\n");
            }
        }

        for (int num : numeros) {
            suma += num;
        }

        long fin = System.nanoTime();
        double tiempo = (fin - inicio) / 1_000_000_000.0;

        texto.append("\n\nLa suma total es: ").append(suma);
        texto.append(String.format("\nTiempo de ejecucion: %.6f segundos", tiempo));

        return new ResultadoAleatorios(texto.toString(), suma, tiempo);
    }

    // Ejercicio 2: Comparar FOR y Gauss
    public String compararMetodos(int n) {
        // Método FOR
        long sumaFor = 0;
        long iteraciones = 0;
        long inicioFor = System.nanoTime();

        for (int i = 1; i <= n; i++) {
            sumaFor += i;
            iteraciones++;
        }

        long finFor = System.nanoTime();
        double tiempoFor = (finFor - inicioFor) / 1_000_000_000.0;

        // Método GAUSS
        long inicioGauss = System.nanoTime();
        long sumaGauss = ((long) n * (n + 1)) / 2;
        long finGauss = System.nanoTime();
        double tiempoGauss = (finGauss - inicioGauss) / 1_000_000_000.0;

        return "--- SUMA CON FOR ---\n"
                + "Resultado: " + sumaFor + "\n"
                + "Iteraciones: " + iteraciones + "\n"
                + String.format("Tiempo: %.9f segundos\n\n", tiempoFor)
                + "--- SUMA CON GAUSS ---\n"
                + "Resultado: " + sumaGauss + "\n"
                + "Iteraciones: 0\n"
                + String.format("Tiempo: %.9f segundos", tiempoGauss);
    }

    // Clase auxiliar interna para devolver datos si se requiere
    public static class ResultadoAleatorios {
        public String texto;
        public long suma;
        public double tiempo;

        public ResultadoAleatorios(String texto, long suma, double tiempo) {
            this.texto = texto;
            this.suma = suma;
            this.tiempo = tiempo;
        }
    }
}