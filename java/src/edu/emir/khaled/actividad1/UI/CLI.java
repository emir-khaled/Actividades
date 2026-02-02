package edu.emir.khaled.actividad1.UI;

import edu.emir.khaled.actividad1.process.ShopManager;
import edu.emir.khaled.actividad1.data.Ticket;
import java.util.Scanner;

public class CLI {

    private ShopManager manager;
    private Scanner scanner;

    public CLI() {
        manager = new ShopManager();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver catálogo y comprar vehículos");
            System.out.println("2. Registrar nuevo vehículo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    procesarVenta();
                    break;
                case 2:
                    registrarNuevoVehiculo();
                    break;
                case 3:
                    ejecutando = false;
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida, ingresa una válida");
            }
        }

        scanner.close();
    }

    private void procesarVenta() {
        System.out.println("\n=== PROCESO DE COMPRA ===");
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();

        boolean continuarComprando = true;

        while (continuarComprando) {
            manager.mostrarCatalogo();

            System.out.print("Seleccione el número del vehículo que desea comprar (1-" + manager.cantidadVehiculosCatalogo() + "): ");
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            if (manager.agregarVehiculoACarrito(seleccion)) {
                System.out.println("Vehículo añadido al carrito: " + manager.obtenerVehiculoPorIndice(seleccion).toString());
            } else {
                System.out.println("Opción inválida, ingresa una válida");
                continue;
            }

            System.out.print("¿Desea agregar otro vehículo? (s/n): ");
            String respuesta = scanner.nextLine();
            continuarComprando = respuesta.equalsIgnoreCase("s");
        }

        if (!manager.getCarritoCompra().isEmpty()) {
            mostrarTicketConfirmacion(nombreCliente);
        } else {
            System.out.println("No se seleccionaron vehículos. Gracias por visitarnos.");
        }
    }

    private void mostrarTicketConfirmacion(String nombreCliente) {
        Ticket ticket = manager.generarTicket(nombreCliente);

        System.out.println("\n" + ticket.generarTicket());

        System.out.print("¿Confirmar compra? (s/n): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            System.out.println("¡Compra realizada con éxito! Gracias por su preferencia.");
            manager.limpiarCarrito();
        } else {
            System.out.println("Compra cancelada. Gracias por visitarnos.");
            manager.limpiarCarrito();
        }
    }

    private void registrarNuevoVehiculo() {
        System.out.println("\n=== REGISTRAR NUEVO VEHÍCULO ===");
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        manager.agregarNuevoVehiculo(marca, modelo, anio, precio);
        System.out.println("Vehículo registrado exitosamente.");
    }
}
