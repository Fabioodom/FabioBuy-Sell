/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.views;

import compraventa.controllers.ProductController;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    private ProductController controller;
    private JTextArea productDisplayArea;

    public HomeFrame() {
        controller = new ProductController();
        setTitle("FabioBuy&Sell - Home");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Productos Disponibles", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        productDisplayArea = new JTextArea();
        productDisplayArea.setEditable(false);
        updateProductDisplay();
        add(new JScrollPane(productDisplayArea), BorderLayout.CENTER);

        JButton addButton = new JButton("Añadir Producto");
        addButton.addActionListener(e -> addProductDialog());
        add(addButton, BorderLayout.SOUTH);
    }

    private void addProductDialog() {
    String nombre = JOptionPane.showInputDialog(this, "Nombre del Producto:");
    String precio = JOptionPane.showInputDialog(this, "Precio:");

    if (nombre != null && precio != null && !nombre.trim().isEmpty() && !precio.trim().isEmpty()) {
        String imagePath = "Sin Imagen"; // Valor por defecto
        controller.addProduct(nombre, precio, imagePath);
        updateProductDisplay();
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void updateProductDisplay() {
        productDisplayArea.setText(String.join("\n", controller.getProducts()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeFrame().setVisible(true));
    }
}

