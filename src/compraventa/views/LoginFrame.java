/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.views;

import compraventa.controllers.UserController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private UserController userController;

    public LoginFrame() {
        userController = new UserController();
        setTitle("Iniciar Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(20);

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(20);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);

        // Acción al presionar el botón de inicio de sesión
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (userController.validateUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
                dispose();
                new HomeFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Diseño de la interfaz
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);
        gbc.gridx = 1;
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);
        gbc.gridx = 1;
        add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

