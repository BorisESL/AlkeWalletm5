package example.service;

import example.model.Cliente;

import java.util.Scanner;

public class Conversion implements OperacionBancaria {
    @Override
    public void realizarOperacion(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione el tipo de conversión:");
        System.out.println("1. Pesos a euros");
        System.out.println("2. Pesos a dólares");
        System.out.println("3. Dólares a pesos");
        System.out.println("4. Euros a dólares");
        System.out.print("\nSeleccione una opción: ");
        int opcionConversion = scanner.nextInt();
        System.out.print("Ingrese la cantidad a convertir: $");
        double cantidadConversion = scanner.nextDouble();
        double resultadoConversion = 0;

        switch (opcionConversion) {
            case 1:
                resultadoConversion = Conversion.pesosAeuros(cantidadConversion);
                System.out.println("\n" + cantidadConversion + " pesos equivalen a " + resultadoConversion + " euros");
                break;
            case 2:
                resultadoConversion = Conversion.pesosAdolares(cantidadConversion);
                System.out.println("\n" + cantidadConversion + " pesos equivalen a " + resultadoConversion + " dólares");
                break;
            case 3:
                resultadoConversion = Conversion.dolaresApesos(cantidadConversion);
                System.out.println("\n" + cantidadConversion + " dólares equivalen a " + resultadoConversion + " pesos");
                break;
            case 4:
                resultadoConversion = Conversion.eurosAdolares(cantidadConversion);
                System.out.println("\n" + cantidadConversion + " euros equivalen a " + resultadoConversion + " dólares");
                break;
            default:
                System.out.println("\nOpción no válida.");
        }
    }

    public static double pesosAeuros(double cantidad) {
        double tipoCambioEuros = 997.89;
        return cantidad / tipoCambioEuros;
    }

    public static double pesosAdolares(double cantidad) {
        double tipoCambioDolares = 744.70;
        return cantidad / tipoCambioDolares;
    }

    public static double dolaresApesos(double cantidad) {
        double tipoCambioDolares = 744.70;
        return cantidad * tipoCambioDolares;
    }

    public static double eurosAdolares(double cantidad) {
        double tipoCambioEuros = 823.89;
        return cantidad * tipoCambioEuros;
    }
}
