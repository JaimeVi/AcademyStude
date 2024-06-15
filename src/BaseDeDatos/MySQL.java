/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Felix Coral
 */
public class MySQL implements DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/AcademyStude";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection connection;
    private Statement statement;

    @Override
    public void Conectar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Conectado Correctamente A La Base De Datos");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public ResultSet Consultar(String Query, Object... Parametros) {
        try {
            PreparedStatement statement = connection.prepareCall(Query);

            for (int i = 0; i < Parametros.length; i++) {
                statement.setObject(i + 1, Parametros[i]);
            }

            return statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void Desconectar() {
        try {
            statement.close();
            connection.close();
            System.out.println("Desconectado De La Base De Datos");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}
