package example.service;

import example.model.Cliente;

public class VerSaldo implements OperacionBancaria {
    @Override
    public void realizarOperacion(Cliente cliente) {
        System.out.println("\nSaldo actual: $" + cliente.getSaldo());
    }
}
