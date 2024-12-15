/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Ventana principal de la aplicación FabioBuy&Sell.
 * Incluye un menú funcional y una lista de productos.
 */
public class HomeFrame extends JFrame {

    private ArrayList<String> productos; // Lista de productos
    private JTextArea productDisplayArea; // Área para mostrar los productos

    /**
     * Constructor de la ventana principal.
     */
    public HomeFrame() {
        setTitle("FabioBuy&Sell - Home");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        productos = new ArrayList<>();
        loadProducts(); // Cargar productos al inicio

        initComponents();
        System.out.println("Ventana principal inicializada.");
    }

    /**
     * Inicializar los componentes de la ventana.
     */
    private void initComponents() {
        setLayout(new BorderLayout());

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú "Herramientas"
        JMenu herramientasMenu = new JMenu("Herramientas");
        JMenuItem configuracionItem = new JMenuItem("Configuración");
        configuracionItem.addActionListener(e -> {
            openConfigDialog();
            System.out.println("Menú: Herramientas > Configuración abierto.");
        });
        herramientasMenu.add(configuracionItem);

        // Menú "Opciones"
        JMenu opcionesMenu = new JMenu("Opciones");
        JMenuItem salirItem = new JMenuItem("Salir");
        salirItem.addActionListener(e -> {
            System.out.println("Menú: Opciones > Salir seleccionado.");
            System.out.println("Saliendo de la aplicación...");
            System.exit(0);
        });
        opcionesMenu.add(salirItem);

        // Agregar menús a la barra
        menuBar.add(herramientasMenu);
        menuBar.add(opcionesMenu);
        setJMenuBar(menuBar);

        // Panel para mostrar productos
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Productos Disponibles", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        productDisplayArea = new JTextArea();
        productDisplayArea.setEditable(false);
        productDisplayArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(productDisplayArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        // Botón para añadir productos
        JButton addProductButton = new JButton("Añadir Producto");
        addProductButton.addActionListener(e -> {
            openAddProductDialog();
            System.out.println("Botón: Añadir Producto presionado.");
        });
        add(addProductButton, BorderLayout.SOUTH);

        updateProductDisplay(); // Mostrar productos iniciales
    }

    /**
     * Cargar productos iniciales.
     */
    private void loadProducts() {
        productos.add("Televisor - $300");
        productos.add("Bicicleta - $150");
        productos.add("Laptop - $700");
        System.out.println("Productos cargados al inicio:");
        for (String producto : productos) {
            System.out.println("- " + producto);
        }
    }

    /**
     * Mostrar productos en el área de visualización.
     */
    private void updateProductDisplay() {
        productDisplayArea.setText("");
        for (String producto : productos) {
            productDisplayArea.append(producto + "\n");
        }
        System.out.println("Productos actualizados en la interfaz.");
    }

    /**
     * Abrir cuadro de diálogo de configuración.
     */
    private void openConfigDialog() {
        JDialog configDialog = new JDialog(this, "Configuración", true);
        configDialog.setSize(300, 200);
        configDialog.setLayout(new BorderLayout());
        JLabel messageLabel = new JLabel("Opciones de configuración disponibles.", JLabel.CENTER);
        configDialog.add(messageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> {
            System.out.println("Configuración cerrada.");
            configDialog.dispose();
        });
        configDialog.add(closeButton, BorderLayout.SOUTH);

        configDialog.setLocationRelativeTo(this);
        configDialog.setVisible(true);
    }

    /**
     * Abrir cuadro de diálogo para añadir productos.
     */
    private void openAddProductDialog() {
        JDialog addProductDialog = new JDialog(this, "Añadir Producto", true);
        addProductDialog.setSize(400, 300);
        addProductDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Nombre del Producto:");
        JTextField nameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField(10);

        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(e -> {
            String nombre = nameField.getText().trim();
            String precio = priceField.getText().trim();
            if (!nombre.isEmpty() && !precio.isEmpty()) {
                productos.add(nombre + " - $" + precio);
                updateProductDisplay();
                addProductDialog.dispose();
                System.out.println("Producto añadido: " + nombre + " - $" + precio);
            } else {
                JOptionPane.showMessageDialog(addProductDialog, "Completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error al añadir producto: Campos incompletos.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        addProductDialog.add(nameLabel, gbc);
        gbc.gridx = 1;
        addProductDialog.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addProductDialog.add(priceLabel, gbc);
        gbc.gridx = 1;
        addProductDialog.add(priceField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        addProductDialog.add(addButton, gbc);

        addProductDialog.setLocationRelativeTo(this);
        addProductDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeFrame frame = new HomeFrame();
            frame.setVisible(true);
            System.out.println("Aplicación FabioBuy&Sell iniciada.");
        });
    }
}
