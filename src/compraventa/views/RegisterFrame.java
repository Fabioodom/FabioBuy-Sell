/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.views;

import compraventa.models.UserModel;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private UserModel userModel;

    public RegisterFrame() {
        userModel = new UserModel();
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JTextField usernameField = new JTextField();

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (!user.isEmpty() && !pass.isEmpty()) {
                userModel.saveUser(user, pass);
                JOptionPane.showMessageDialog(this, "Usuario registrado.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Completa los campos.");
            }
        });

        add(userLabel);
        add(usernameField);
        add(passLabel);
        add(passwordField);
        add(registerButton);
    }
}

