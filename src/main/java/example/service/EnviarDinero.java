package example.service;

import example.model.Cliente;

import java.util.Scanner;

public class EnviarDinero implements OperacionBancaria {
    private Banco banco;

    public EnviarDinero(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void realizarOperacion(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el número de cuenta del destinatario: ");
        String numeroDestinatario = scanner.next();
        System.out.print("Ingrese la cantidad a enviar: $");
        double cantidadEnvio = scanner.nextDouble();
        Cliente destinatario = banco.autenticar(numeroDestinatario);
        if (destinatario != null) {
            cliente.enviarDinero(cantidadEnvio);
            destinatario.recibirDinero(cantidadEnvio);
            System.out.println("Transferencia exitosa su nuevo saldo es $ "+ cliente.getSaldo());

        } else {
            System.out.println("El número de cuenta del destinatario no es válido.");
        }
    }
}
