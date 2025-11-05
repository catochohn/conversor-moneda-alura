package com.challengeone.java.backend.conversormonedas;

import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private List<Moneda> conversiones;

    public HistorialConversiones() {
        this.conversiones = new ArrayList<>();
    }

    public void agregarConversion(String monedaOrigen, String monedaDestino,
                                  double montoOriginal, double montoConvertido) {
        Moneda conversion = new Moneda(monedaOrigen, monedaDestino,
                montoOriginal, montoConvertido);
        conversiones.add(conversion);
    }

    public void mostrarHistorial() {
        if (conversiones.isEmpty()) {
            System.out.println("\nNo hay conversiones en el historial.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("      HISTORIAL DE CONVERSIONES");
        System.out.println("========================================");

        for (int i = 0; i < conversiones.size(); i++) {
            System.out.println((i + 1) + ") " + conversiones.get(i));
        }

        System.out.println("========================================");
    }

    public List<Moneda> getConversiones() {
        return new ArrayList<>(conversiones);
    }

    public int getTotalConversiones() {
        return conversiones.size();
    }
}