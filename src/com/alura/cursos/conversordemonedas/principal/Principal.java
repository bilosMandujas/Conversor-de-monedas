package com.alura.cursos.conversordemonedas.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal{

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double cantidad;
        String tipoMoneda = "";


        while (true) {
            System.out.println("===== Bienvenidos al conversor de monedas =====");
            System.out.println("1.- Dólar a Peso Mexicano");
            System.out.println("2.- Peso Mexicano a Dólar");
            System.out.println("3.- Dólar a Real Brasileño");
            System.out.println("4.- Real Brasileño a Dólar");
            System.out.println("5.- Dólar a Peso Colombiano");
            System.out.println("6.- Peso Colombiano a Dólar");
            System.out.println("7.- Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Saliendo del programa...");
                scanner.close();
                System.exit(0);
            }

            while (opcion < 1 || opcion > 7) {
                System.out.println("Opción no válida, intente de nuevo...");
                System.out.print("Seleccione una opción válida: ");
                opcion = scanner.nextInt();
            }

            if (opcion == 1 || opcion == 3 || opcion == 5) {
                tipoMoneda = "USD";
            }

            if(opcion == 2){
                tipoMoneda = "MXN";
            }

            if(opcion == 4){
                tipoMoneda = "BRL";
            }
            if(opcion == 6){
                tipoMoneda = "COP";
            }


            System.out.print("¿Qué cantidad quieres convertir?: ");
            cantidad = scanner.nextDouble();

            double resultado = 0.0;


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();


            String urlApiBase = "https://v6.exchangerate-api.com/v6/d97b8d52e44e420b27de421d/latest/"+ tipoMoneda; // Dólar por defecto


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApiBase))
                    .build();


            HttpResponse<String>
                    response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());


            Map<String, Object> jsonResponse = gson.fromJson(response.body(), Map.class);
            Map<String, Double> conversionRates = (Map<String, Double>) jsonResponse.get("conversion_rates");



            switch (opcion) {
                case 1:
                    resultado = cantidad * conversionRates.get("MXN");
                    System.out.printf("%.2f USD son %.2f MXN%n", cantidad, resultado);
                    break;
                case 2:
                    resultado = cantidad * conversionRates.get("USD");
                    System.out.printf("%.2f MXN son %.2f USD%n", cantidad, resultado);
                    break;
                case 3:
                    resultado = cantidad * conversionRates.get("BRL");
                    System.out.printf("%.2f USD son %.2f BRL%n", cantidad, resultado);
                    break;
                case 4:
                    resultado = cantidad * conversionRates.get("USD");
                    System.out.printf("%.2f BRL son %.2f USD%n", cantidad, resultado);
                    break;
                case 5:
                    resultado = cantidad * conversionRates.get("COP");
                    System.out.printf("%.2f USD son %.2f COP%n", cantidad, resultado);
                    break;
                case 6:
                    resultado = cantidad * conversionRates.get("USD");
                    System.out.printf("%.2f COP son %.2f USD%n", cantidad, resultado);
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
            System.out.println();
        }
    }
}






