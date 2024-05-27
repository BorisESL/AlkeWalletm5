package example.service;

import example.model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Cliente> clientes;

    public Banco() {
        this.clientes = new HashMap<>();
        clientes.put("123456", new Cliente("Juan Oh", "12345678-9", "123456", 10000));
        clientes.put("098765", new Cliente("Novack Djokovic", "14993475-1", "098765", 15000));
    }

    public Cliente autenticar(String numeroCuenta) {
        return clientes.getOrDefault(numeroCuenta, null);
    }
}
