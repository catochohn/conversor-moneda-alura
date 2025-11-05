package com.challengeone.java.backend.conversormonedas;

import java.io.IOException;

public class ConversorApp {
    public static void main(String[] args) {
        try {
            Conversor.iniciarMenu();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el conversor: " + e.getMessage());
        }
    }
}