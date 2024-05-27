package example.service;

import example.model.Cliente;

import java.util.Scanner;

public class DepositarFondo implements OperacionBancaria {
    private Banco banco;

    @Override
    public void realizarOperacion(Cliente cliente) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese monto a depositar");
        double monto = scanner.nextDouble();
        cliente.depositarDinero(monto);
        System.out.println("Su nuevo saldo es: $" + cliente.getSaldo());
    }


}

