/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.views;

import compraventa.controllers.ProductController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ProductViewFrame extends JFrame {
    private ProductController controller;
    private JTextArea productArea;
    private JLabel imagePreviewLabel; 
    private File selectedImageFile;

    public ProductViewFrame() {
        controller = new ProductController();
        setTitle("Lista de Productos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        productArea = new JTextArea();
        productArea.setText(String.join("\n", controller.getProducts()));
        productArea.setEditable(false);
        add(new JScrollPane(productArea), BorderLayout.CENTER);

        JButton addProductButton = new JButton("Añadir Producto");
        addProductButton.addActionListener(e -> openAddProductDialog());
        add(addProductButton, BorderLayout.SOUTH);
    }

    private void openAddProductDialog() {
        JDialog addProductDialog = new JDialog(this, "Añadir Producto", true);
        addProductDialog.setSize(400, 400);
        addProductDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Nombre del Producto:");
        JTextField nameField = new JTextField(20);

        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField(10);

        JLabel imageLabel = new JLabel("Imagen del Producto:");
        JButton chooseImageButton = new JButton("Seleccionar Imagen");
        imagePreviewLabel = new JLabel();
        imagePreviewLabel.setPreferredSize(new Dimension(150, 150));
        imagePreviewLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        chooseImageButton.addActionListener(e -> openImageFileChooser());

        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(e -> {
            String nombre = nameField.getText().trim();
            String precio = priceField.getText().trim();

            if (!nombre.isEmpty() && !precio.isEmpty() && selectedImageFile != null) {
                String imagePath = saveImageToLocal(selectedImageFile);
                controller.addProduct(nombre, precio, imagePath);
                updateProductDisplay();
                addProductDialog.dispose();
                JOptionPane.showMessageDialog(this, "Producto añadido correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Completa todos los campos y selecciona una imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; addProductDialog.add(nameLabel, gbc);
        gbc.gridx = 1; addProductDialog.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; addProductDialog.add(priceLabel, gbc);
        gbc.gridx = 1; addProductDialog.add(priceField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; addProductDialog.add(imageLabel, gbc);
        gbc.gridx = 1; addProductDialog.add(chooseImageButton, gbc);
        gbc.gridx = 1; gbc.gridy = 3; addProductDialog.add(imagePreviewLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; addProductDialog.add(addButton, gbc);

        addProductDialog.setLocationRelativeTo(this);
        addProductDialog.setVisible(true);
    }

    private void openImageFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedImageFile.getAbsolutePath());
            Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imagePreviewLabel.setIcon(new ImageIcon(scaledImage));
        }
    }

    private String saveImageToLocal(File imageFile) {
        try {
            String targetPath = "resources/images/" + imageFile.getName();
            Path target = Paths.get(targetPath);
            Files.createDirectories(target.getParent());
            Files.copy(imageFile.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
            return targetPath;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void updateProductDisplay() {
        productArea.setText(String.join("\n", controller.getProducts()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductViewFrame().setVisible(true));
    }
}


