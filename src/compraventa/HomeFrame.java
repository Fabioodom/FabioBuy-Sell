/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HomeFrame extends JFrame {

    private JTextField nameField;
    private JTextField priceField;
    private JTextArea descriptionArea;
    private JButton addImageButton;
    private JButton sellButton;
    private JLabel imageLabel;

    public HomeFrame() {
        setTitle("Añadir Artículo");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Icono de añadir imagen
        imageLabel = new JLabel(new ImageIcon("C:\\Users\\dam2\\Downloads\\fabiobuy_and_sell_logo_512x512.jpg")); // Cambiar ruta si es necesario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(imageLabel, gbc);

        // Botón de añadir imagen
        addImageButton = new JButton("Añadir Imagen");
        addImageButton.setBackground(new Color(70, 130, 180));
        addImageButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        add(addImageButton, gbc);

        // Campo para Nombre Artículo
        JLabel nameLabel = new JLabel("Nombre Artículo");
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameField, gbc);

        // Campo para Precio
        JLabel priceLabel = new JLabel("Precio");
        priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(priceLabel, gbc);

        priceField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(priceField, gbc);

        // Campo para Descripción
        JLabel descriptionLabel = new JLabel("Descripción");
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(descriptionLabel, gbc);

        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JScrollPane(descriptionArea), gbc);

        // Botón de poner en venta
        sellButton = new JButton("Poner en Venta");
        sellButton.setBackground(new Color(70, 130, 180));
        sellButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 10, 10, 10);
        add(sellButton, gbc);

        // Acción para el botón de subir imagen
        addImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage img = ImageIO.read(selectedFile);

                        // Escalar la imagen para ajustarla dentro del recuadro
                        Image scaledImage = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        imageLabel.setIcon(new ImageIcon(scaledImage));
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Acción para el botón de poner en venta
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreArticulo = nameField.getText();
                String precio = priceField.getText();
                String descripcion = descriptionArea.getText();

                if (nombreArticulo.isEmpty() || precio.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Artículo puesto en venta: " + nombreArticulo);
                }
            }
        });
    }

    public static void main(String[] args) {
        new HomeFrame().setVisible(true);
    }
}
