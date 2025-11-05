package com.challengeone.java.backend.conversormonedas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moneda {
    private String monedaOrigen;
    private String monedaDestino;
    private double montoOriginal;
    private double montoConvertido;
    private LocalDateTime fechaHora;

    public Moneda(String monedaOrigen, String monedaDestino,
                  double montoOriginal, double montoConvertido) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoOriginal = montoOriginal;
        this.montoConvertido = montoConvertido;
        this.fechaHora = LocalDateTime.now();
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public String getFechaHoraFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHora.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s => %.2f %s [%s]",
                montoOriginal, monedaOrigen,
                montoConvertido, monedaDestino,
                getFechaHoraFormateada());
    }
}