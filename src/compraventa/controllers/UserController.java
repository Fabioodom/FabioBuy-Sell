/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraventa.controllers;

import compraventa.models.UserModel;

import java.util.ArrayList;

public class UserController {
    private UserModel userModel;

    public UserController() {
        userModel = new UserModel();
    }

    // Método para registrar un usuario
    public void registerUser(String username, String password) {
        userModel.saveUser(username, password);
    }

    // Método para validar si las credenciales son correctas
    public boolean validateUser(String username, String password) {
        ArrayList<String> users = userModel.loadUsers();
        for (String user : users) {
            String[] userData = user.split(";");
            if (userData.length == 2 && userData[0].equals(username) && userData[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

