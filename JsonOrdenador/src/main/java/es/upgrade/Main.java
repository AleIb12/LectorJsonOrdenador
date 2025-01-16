package es.upgrade;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Ordenador ordenador = null;
        File f = new File("Ordenador.json");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString(); // El contenido completo del archivo en un String
            ordenador = gson.fromJson(json, Ordenador.class); // Deserializa el JSON
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }

        // Verificar si la deserialización fue exitosa
        if (ordenador != null) {
            System.out.println("Nombre del ordenador: " + ordenador.nombre);
            System.out.println(ordenador); // Imprime la representación del objeto
        } else {
            System.err.println("No se pudo deserializar el JSON.");
        }
    }
}
