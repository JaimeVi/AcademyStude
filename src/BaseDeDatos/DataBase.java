/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Felix Coral
 */
public interface DataBase {

    void Conectar();

    ResultSet Consultar(String Query, Object... Parametros);

    void Desconectar();

    Connection getConnection();
}
