package es.upgrade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Ordenador ordenador = null;
        File f = new File("C:\\Users\\josea\\Documents\\LectorJsonOrdenador\\JsonOrdenador\\Ordenador.json");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();
            
            // Parse the outer "Ordenador" object
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            ordenador = gson.fromJson(jsonObject.get("Ordenador"), Ordenador.class);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }

        if (ordenador != null) {
            OrdenadorUI ui = new OrdenadorUI();
            ui.mostrarOrdenador(ordenador);
            ui.setLocationRelativeTo(null);
            SwingUtilities.invokeLater(() -> ui.setVisible(true));
        } else {
            System.err.println("No se pudo deserializar el JSON.");
        }
    }
}