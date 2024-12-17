/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.controllers;

import compraventa.models.ProductModel;

public class ProductController {
    private ProductModel productModel;

    public ProductController() {
        productModel = new ProductModel();
    }

    public void addProduct(String nombre, String precio, String imagePath) {
        productModel.addProduct(nombre + " - $" + precio + " | Imagen: " + imagePath);
    }

    public String[] getProducts() {
        return productModel.getProductos().toArray(new String[0]);
    }
}


