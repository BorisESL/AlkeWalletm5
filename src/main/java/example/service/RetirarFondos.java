package example.service;

import example.model.Cliente;

import java.util.Scanner;

public class RetirarFondos implements OperacionBancaria {
    @Override
    public void realizarOperacion(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese la cantidad a retirar: $");
        double cantidadRetiro = scanner.nextDouble();
        cliente.retirar(cantidadRetiro);
        System.out.println("Su nuevo saldo es: $" + cliente.getSaldo());
    }
}
