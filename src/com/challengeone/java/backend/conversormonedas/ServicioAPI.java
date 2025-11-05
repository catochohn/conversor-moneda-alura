package com.challengeone.java.backend.conversormonedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioAPI {
    private static final String API_KEY = "cfb68159d70bc03b0cfe559f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient cliente;

    public ServicioAPI() {
        this.cliente = HttpClient.newHttpClient();
    }

    public double obtenerTasaConversion(String monedaOrigen, String monedaDestino)
            throws IOException, InterruptedException {

        String url = BASE_URL + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> respuesta = cliente.send(solicitud,
                    HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {
                return parsearTasa(respuesta.body());
            } else {
                throw new IOException("Error en la API. Código: " + respuesta.statusCode());
            }
        } catch (Exception e) {
            throw new IOException("Error al conectar con la API: " + e.getMessage());
        }
    }

    private double parsearTasa(String jsonRespuesta) {
        JsonElement elemento = JsonParser.parseString(jsonRespuesta);
        JsonObject objetoJson = elemento.getAsJsonObject();

        return objetoJson.get("conversion_rate").getAsDouble();
    }
}