package com.challengeone.java.backend.conversormonedas;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    private static final ServicioAPI servicioAPI = new ServicioAPI();
    private static final HistorialConversiones historial = new HistorialConversiones();
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciarMenu() throws IOException, InterruptedException {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            if (opcion == 7) {
                mostrarHistorial();
            } else if (opcion == 8) {
                System.out.println("\n¡Gracias por usar el Conversor de Monedas!");
                continuar = false;
            } else if (opcion >= 1 && opcion <= 6) {
                procesarConversion(opcion);
            } else {
                System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===========================================");
        System.out.println("  Sea bienvenido/a al Conversor de Moneda");
        System.out.println("===========================================");
        System.out.println("1) Dólar (USD) => Peso argentino (ARS)");
        System.out.println("2) Peso argentino (ARS) => Dólar (USD)");
        System.out.println("3) Dólar (USD) => Real brasileño (BRL)");
        System.out.println("4) Real brasileño (BRL) => Dólar (USD)");
        System.out.println("5) Dólar (USD) => Peso colombiano (COP)");
        System.out.println("6) Peso colombiano (COP) => Dólar (USD)");
        System.out.println("7) Ver historial de conversiones");
        System.out.println("8) Salir");
        System.out.println("===========================================");
        System.out.print("Elija una opción válida: ");
    }

    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void procesarConversion(int opcion) throws IOException, InterruptedException {
        String monedaOrigen = "";
        String monedaDestino = "";

        switch (opcion) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "ARS";
                break;
            case 2:
                monedaOrigen = "ARS";
                monedaDestino = "USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                break;
            case 4:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "COP";
                break;
            case 6:
                monedaOrigen = "COP";
                monedaDestino = "USD";
                break;
        }

        System.out.print("\nIngrese el valor que desea convertir: ");
        double monto = scanner.nextDouble();

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }

        double tasa = servicioAPI.obtenerTasaConversion(monedaOrigen, monedaDestino);
        double resultado = calcularConversion(monto, tasa);

        System.out.printf("\n%.2f %s equivale a %.2f %s\n",
                monto, monedaOrigen, resultado, monedaDestino);

        historial.agregarConversion(monedaOrigen, monedaDestino, monto, resultado);
    }

    private static double calcularConversion(double monto, double tasa) {
        return monto * tasa;
    }

    private static void mostrarHistorial() {
        historial.mostrarHistorial();
    }
}