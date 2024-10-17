/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterFrame() {
        setTitle("Registro de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        registerButton = new JButton("Registrarse");
        registerButton.setBounds(10, 80, 150, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para el registro
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(null, "Usuario " + username + " registrado exitosamente");
                dispose();
            }
        });

        add(panel);
    }
}
