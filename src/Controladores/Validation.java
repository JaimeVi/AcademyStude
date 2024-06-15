/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import BaseDeDatos.DataBase;
import BaseDeDatos.MySQL_DB.Consultations;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felix Coral
 */
public class Validation {

    private final DataBase BaseDatos;

    public Validation(DataBase BaseDatos) {
        this.BaseDatos = BaseDatos;
    }

    public String Verification(String StarUser, String Password) throws SQLException {

        Consultations consultations = new Consultations(BaseDatos);
        ResultSet resultSet = consultations.CheckStarUser(StarUser);
        boolean joined = false;
        boolean UserFound = false;
        String tipoUsuario = null;
        while (resultSet.next()) {
            UserFound = true;
            String pass = resultSet.getString("Password");
            if (Password.equals(pass)) {
                joined = true;
                tipoUsuario = resultSet.getString("Rol");
                break;
            }
        }
        if (!UserFound) {
            return "El Usuario Ingresado No Existe";
        } else if (!joined) {
            return "La Contraseña Ingresada Es Incorrecta";
        } else {
            return "Inicio De Sesión Exitoso , Bienvenido " + tipoUsuario;

        }
    }

    public String CheckDatos(String starUser, String DNI) throws SQLException {
        Consultations consultations = new Consultations(BaseDatos);
        ResultSet resultSet = consultations.CheckDNIyUser(starUser);
        boolean userFound = false;
        boolean correctData = false;

        while (resultSet.next()) {
            userFound = true;
            String databaseDNI = resultSet.getString("DNI");

            if (DNI.equals(databaseDNI)) {
                correctData = true;
                break;
            }
        }

        if (!userFound) {
            return "El usuario ingresado no existe en la base de datos.";
        } else if (!correctData) {
            return "El DNI ingresado no coincide con el usuario especificado.";
        } else {
            return "Los datos han sido confirmados.";
        }
    }
}
