/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.models;

import java.io.*;
import java.util.ArrayList;

public class UserModel {
    private final String USER_FILE = "usuarios.txt";

    public void saveUser(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(username + ";" + password);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar usuario.");
        }
    }

    public ArrayList<String> loadUsers() {
        ArrayList<String> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(line);
            }
        } catch (IOException e) {
            System.out.println("No se encontró usuarios.txt.");
        }
        return users;
    }
}

