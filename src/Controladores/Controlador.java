package Controladores;

import BaseDeDatos.DataBase;
import BaseDeDatos.MySQL_DB.Consultations;
import Modelos.Users;
import Vistas.AttendanceRecord;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controlador implements MouseListener {

    private final DataBase BaseDatos;
    private final AttendanceRecord viewAttendaceRecord;
    private ServerSocket serverSocket;
    private Map<Socket, String> barcodeMap;
    private Users usuario;

    public Controlador(DataBase BaseDatos, AttendanceRecord viewAttendaceRecord) {
        this.BaseDatos = BaseDatos;
        this.viewAttendaceRecord = viewAttendaceRecord;
        configurarBoton();
        barcodeMap = new HashMap<>();
        iniciarServidor();
    }

    private void configurarBoton() {
        viewAttendaceRecord.Camara.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == viewAttendaceRecord.Camara) {
            consultar();
        }
    }

    private void iniciarServidor() {
        int port = 54321;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port);

            new Thread(() -> {
                while (true) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Conexión establecida con cliente: " + clientSocket.getInetAddress().getHostAddress());
                        procesarComunicacionConCliente(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirCamara() {
        String pythonScriptPath = "intento2.py";

        try {
            Process process = Runtime.getRuntime().exec("python " + pythonScriptPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("Barcode Data:")) {
                    String barcodeValue = line.substring("Barcode Data:".length()).trim();
                    viewAttendaceRecord.txt_dni.setText(barcodeValue);
                    buscarPorDNI();
                }
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void procesarComunicacionConCliente(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message = reader.readLine();

            String[] parts = message.split(":");
            if (parts.length == 2) {
                String receivedPassword = parts[0];
                String barcodeData = parts[1];

                String password = "Zamo2106";
                if (receivedPassword.equals(password)) {
                    writer.println("Código de barras recibido y confirmado.");
                    barcodeMap.put(clientSocket, barcodeData);
                    System.out.println("Código de barras almacenado en el mapa: " + barcodeData);
                } else {
                    writer.println("Contraseña incorrecta: " + receivedPassword);
                    System.out.println("Intento de conexión con contraseña incorrecta: " + receivedPassword);
                }
            } else {
                writer.println("Formato incorrecto del mensaje.");
                System.out.println("Mensaje recibido con formato incorrecto: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void consultar() {
        String barcodeData = viewAttendaceRecord.txt_codigo.getText();
        System.out.println(barcodeData);

        String serverAddress = "127.0.0.1";
        int serverPort = 54321;
        String password = "Zamo2106";

        try (Socket socket = new Socket(serverAddress, serverPort); PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String message = password + ":" + barcodeData;
            writer.println(message);

            abrirCamara();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void detenerServidor() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buscarPorDNI() {
        System.out.println("llegnado");
        String DNI = viewAttendaceRecord.txt_dni.getText();
        System.out.println(DNI);

        Consultations consultasDb = new Consultations(BaseDatos);
        ResultSet resultSet = consultasDb.BuscarProDNI(DNI);

        try {
            while (resultSet.next()) {
                int userID = resultSet.getInt("UserID");
                String name = resultSet.getString("Name");
                String lastname = resultSet.getString("Lastname");
                String dni = resultSet.getString("DNI");
                String email = resultSet.getString("Email");
                String starUser = resultSet.getString("StarUser");
                String password = resultSet.getString("Password");
                String verifyCode = resultSet.getString("VerifyCode");
                String rol = resultSet.getString("Rol");
                usuario = new Users(userID, name, lastname, dni, email, starUser, password, verifyCode, rol);
                System.out.println("Usuario: "+ usuario.getDNI());
                mostrarDatosUsuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private void mostrarDatosUsuario() {
        viewAttendaceRecord.txt_codigo.setText(usuario.getStarUser()); 
        viewAttendaceRecord.txt_nombre.setText(usuario.getName()); 
        viewAttendaceRecord.txt_apellido.setText(usuario.getLastname()); 
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
}
