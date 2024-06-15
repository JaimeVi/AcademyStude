/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos.MySQL_DB;

import BaseDeDatos.DataBase;
import java.sql.ResultSet;

/**
 *
 * @author Felix Coral
 */
public class Consultations {

    private final DataBase database;

    public Consultations(DataBase database) {
        this.database = database;
    }

    public ResultSet CheckStarUser(String starUser) {
        String query = "SELECT * FROM User Where StarUser = ?";
        return database.Consultar(query, starUser);
    }

    public ResultSet CheckDNIyUser(String starUser) {
        String query = "SELECT StarUser, DNI FROM User WHERE StarUser = ?";
        return database.Consultar(query, starUser);
    }

    public ResultSet NameandSurname(String Users) {
        String query = "SELECT Name, Lastname FROM User WHERE StarUser = ?";
        return database.Consultar(query, Users);
    }
    
    public ResultSet BuscarProDNI(String Users) {
        String query = "SELECT * FROM User WHERE DNI = ?";
        return database.Consultar(query, Users);
    }

}
