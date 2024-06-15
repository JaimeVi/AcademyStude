/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Felix Coral
 */
public class Users {

    private int UserID;
    private String Name;
    private String Lastname;
    private String DNI;
    private String Email;
    private String StarUser;
    private String Password;
    private String VerifyCode;
    private String Rol;

    public Users(int UserID, String Name, String Lastname, String DNI, String Email, String StarUser, String Password, String VerifyCode, String Rol) {
        this.UserID = UserID;
        this.Name = Name;
        this.Lastname = Lastname;
        this.DNI = DNI;
        this.Email = Email;
        this.StarUser = StarUser;
        this.Password = Password;
        this.VerifyCode = VerifyCode;
        this.Rol = Rol;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getStarUser() {
        return StarUser;
    }

    public void setStarUser(String StarUser) {
        this.StarUser = StarUser;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String VerifyCode) {
        this.VerifyCode = VerifyCode;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    

}
