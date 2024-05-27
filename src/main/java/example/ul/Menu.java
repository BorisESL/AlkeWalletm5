package example.ul;

import example.model.Cliente;
import example.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Banco banco;
    private Map<Integer, OperacionBancaria> operaciones;

    public Menu(Banco banco) {
        this.banco = banco;
        this.operaciones = new HashMap<>();
        operaciones.put(1, new VerSaldo());
        operaciones.put(2, new RetirarFondos());
        operaciones.put(3, new DepositarFondo());
        operaciones.put(4, new EnviarDinero(banco));
        operaciones.put(5, new Conversion());
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese número de su cuenta:");
        String numeroCuenta = scanner.nextLine();
        Cliente cliente = banco.autenticar(numeroCuenta);

        if (cliente == null) {
            System.out.println("Número de cuenta incorrecto");
            return;
        }

        boolean continuar = true;

        while (continuar) {

            System.out.println("\nBienvenido, " + cliente.getNombre() + "!\n");
            System.out.println("Seleccione una opción:");
            System.out.println("[1] Ver saldo");
            System.out.println("[2] Retirar fondos");
            System.out.println("[3] Depositar fondos");
            System.out.println("[4] Enviar dinero");
            System.out.println("[5] Convertir moneda");
            System.out.println("[6] Salir");

            System.out.print("\nSeleccione una opción: ");
            int opcion = scanner.nextInt();
            if (opcion == 6) {
                System.out.println("\nSaliendo de la aplicación");
                break;
            }
            OperacionBancaria operacion = operaciones.get(opcion);
            if (operacion != null) {
                operacion.realizarOperacion(cliente);
            } else {
                System.out.println("Opción no válida.");

            }

        }

    }
}
