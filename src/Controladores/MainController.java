/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controladores;

import BaseDeDatos.DataBase;
import BaseDeDatos.MySQL;
import BaseDeDatos.MySQL_DB.Consultations;
import Vistas.AttendanceRecord;
import Vistas.Code;
import Vistas.MainPanel;
import Vistas.SignIn;
import Vistas.Star;
import Vistas.RecoverPassword;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Felix Coral
 */
public class MainController implements MouseListener, ActionListener {

    private final DataBase BaseDatos;
    private final Star viewStar;
    private final SignIn viewLogin;
    private final RecoverPassword viewRecoverPassword;
    private final Code viewCode;
    private final MainPanel viewMainPanel;
    private final Validation validation;
    private final AttendanceRecord viewAttendaceRecord;
    private final Controlador controller;

    public MainController() {

        BaseDatos = new MySQL();
        viewStar = new Star();
        viewLogin = new SignIn();
        viewRecoverPassword = new RecoverPassword();
        viewCode = new Code();
        viewMainPanel = new MainPanel();
        validation = new Validation(BaseDatos);
        viewAttendaceRecord = new AttendanceRecord();
        controller = new Controlador(BaseDatos, viewAttendaceRecord);

        BaseDatos.Conectar();
        Buttons();
    }

    public void Star() {
        viewStar.setVisible(true);
        viewStar.setLocationRelativeTo(null);
    }

    public void Buttons() {
        changePanel(viewLogin);
        viewLogin.RecuperarContraseña.addMouseListener(this);
        viewRecoverPassword.VolverInicio.addMouseListener(this);
        viewLogin.Ingresar.addMouseListener(this);
        viewRecoverPassword.validarCredencial.addMouseListener(this);
    }

    private void changePanel(JPanel nuevoPanel) {
        viewStar.PanelCambio.removeAll();
        nuevoPanel.setSize(400, 430);
        nuevoPanel.setLocation(0, 0);
        viewStar.PanelCambio.add(nuevoPanel, BorderLayout.CENTER);
        viewStar.PanelCambio.revalidate();
        viewStar.PanelCambio.repaint();
    }

    private void changeMain(JPanel nuevoPanel) {
        viewMainPanel.cambioPrincipal.removeAll();
        nuevoPanel.setSize(1045, 681);
        nuevoPanel.setLocation(0, 0);
        viewMainPanel.cambioPrincipal.add(nuevoPanel, BorderLayout.CENTER);
        viewMainPanel.cambioPrincipal.revalidate();
        viewMainPanel.cambioPrincipal.repaint();
    }

    private void SingIn() {
        String User = viewLogin.Usuario.getText();
        String Pass = viewLogin.Contraseña.getText();

        if (User.isEmpty() || Pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error : Por Favor LLene Todo Los Campos");
            return;
        }
        try {
            String Message = validation.Verification(User, Pass);
            JOptionPane.showMessageDialog(null, Message);
            if (Message.startsWith("Inicio De Sesión Exitoso")) {
                viewMainPanel.setVisible(true);
                viewMainPanel.setLocationRelativeTo(null);
                viewStar.dispose();
                changeMain(viewAttendaceRecord);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        }
    }

    private void RecoverPassword() {
        String User = viewRecoverPassword.User.getText();
        String DNI = viewRecoverPassword.DNI.getText();
        if (User.isEmpty() || DNI.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error : Por Favor LLene Todo Los Campos");
            return;
        }
        try {
            String Message = validation.CheckDatos(User, DNI);
            JOptionPane.showMessageDialog(null, Message);
            if (Message.startsWith("Los datos han sido confirmados")) {
                //Name y Last Name
                Consultations consulta = new Consultations(BaseDatos);
                ResultSet resultSet = consulta.NameandSurname(User);

                if (resultSet.next()) {
                    String nombre = resultSet.getString("Name");
                    String apellido = resultSet.getString("Lastname");
                    String primerNombre = obtenerPrimerNombre(nombre);
                    String primerApellido = obtenerPrimerYSegundoApellido(apellido);
                    viewCode.NombreApellido.setText(primerNombre + " " + primerApellido);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado en la base de datos");
                }
                changePanel(viewCode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : Usuario No Existente " + e.getMessage());
        }
    }

    private String obtenerPrimerNombre(String nombreCompleto) {
        String[] partes = nombreCompleto.split(" ");
        return partes[0];
    }

    private String obtenerPrimerYSegundoApellido(String apellidoCompleto) {
        String[] partes = apellidoCompleto.split(" ");
        if (partes.length >= 2) {
            return partes[0] + " " + partes[1];
        } else {
            return partes[0];
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == viewLogin.Ingresar) {
            SingIn();
        } else if (e.getSource() == viewRecoverPassword.VolverInicio) {
            changePanel(viewLogin);
            viewLogin.RecuperarContraseña.setForeground(Color.BLACK);
        } else if (e.getSource() == viewLogin.RecuperarContraseña) {
            changePanel(viewRecoverPassword);
        } else if (e.getSource() == viewRecoverPassword.validarCredencial) {
            RecoverPassword();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        MainController run = new MainController();
        run.Star();
    }
}
