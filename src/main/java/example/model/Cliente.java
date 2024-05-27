package example.model;

public class Cliente {
    private String nombre;
    private String rut;
    private String numeroCuenta;
    private double saldo;

    public Cliente(String nombre, String rut, String numeroCuenta, double saldo) {
        this.nombre = nombre;
        this.rut = rut;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void enviarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
           // System.out.println("Transferencia exitosa.");
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }

    public void recibirDinero(double cantidad) {
        saldo += cantidad;
    }

    public void depositarDinero(double cantidad) {

        saldo += cantidad;
    }
}
