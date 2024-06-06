package example.model;

public class Usuario {
    int id;
    String nombre;
    String rut;
    String password;
    String email;
    double balance;

    public Usuario(int id, String nombre, String rut, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.password = password;
        this.email = email;
        double balance;
    }

    public Usuario(int id, String nombre, String rut, String password, String email, double balance) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Usuario() {

    }
}
