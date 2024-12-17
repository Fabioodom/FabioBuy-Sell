/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.models;

import java.io.*;
import java.util.ArrayList;

public class ProductModel {
    private final String PRODUCT_FILE = "productos.txt";
    private ArrayList<String> productos;

    public ProductModel() {
        productos = new ArrayList<>();
        loadProductsFromFile();
    }

    private void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                productos.add(line);
            }
        } catch (IOException e) {
            System.out.println("No se encontró productos.txt. Creando uno nuevo.");
        }
    }

    public void addProduct(String producto) {
        productos.add(producto);
        saveProductsToFile();
    }

    private void saveProductsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUCT_FILE))) {
            for (String producto : productos) {
                bw.write(producto);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los productos.");
        }
    }

    public ArrayList<String> getProductos() {
        return productos;
    }
}


