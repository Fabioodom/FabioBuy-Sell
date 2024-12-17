/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Fabio Dominguez
 */



 public class SplashScreen extends JWindow {

    private final int splashTime = 3000; // Tiempo de duración en milisegundos (3 segundos)

    public void showSplash() {
        // Crear el contenido del Splash Screen
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        content.setLayout(new BorderLayout());

        // Imagen para el Splash Screen
        JLabel splashImage = new JLabel(new ImageIcon(getClass().getResource("/images/splash.png")));
        content.add(splashImage, BorderLayout.CENTER);

        // Texto opcional en la parte inferior
        JLabel footer = new JLabel("Cargando FabioBuy&Sell...", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.BOLD, 14));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(footer, BorderLayout.SOUTH);

        // Configuración de la ventana del Splash Screen
        setContentPane(content);
        setSize(500, 400);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Mostrar el Splash Screen
        setVisible(true);

        // Esperar el tiempo definido y luego cerrar
        try {
            Thread.sleep(splashTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
        dispose();
    }
}
