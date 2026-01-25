package edu.emir.khaled.actividad1.process;

import edu.emir.khaled.actividad1.data.Autos;
import edu.emir.khaled.actividad1.data.Ticket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopManager {

    private Catalogo catalogo;
    private List<Autos> carritoCompra;

    public ShopManager() {
        catalogo = new Catalogo();
        carritoCompra = new ArrayList<>();
    }

    public void mostrarCatalogo() {
        catalogo.mostrarCatalogo();
    }

    public boolean agregarVehiculoACarrito(int seleccion) {
        if (seleccion >= 1 && seleccion <= catalogo.cantidadVehiculos()) {
            Autos vehiculoSeleccionado = catalogo.obtenerVehiculoPorIndice(seleccion - 1);
            carritoCompra.add(vehiculoSeleccionado);
            return true;
        }
        return false;
    }

    public Autos obtenerVehiculoPorIndice(int indice) {
        if (indice >= 1 && indice <= catalogo.cantidadVehiculos()) {
            return catalogo.obtenerVehiculoPorIndice(indice - 1);
        }
        return null;
    }

    public int cantidadVehiculosCatalogo() {
        return catalogo.cantidadVehiculos();
    }

    public List<Autos> getCarritoCompra() {
        return new ArrayList<>(carritoCompra);
    }

    public Ticket generarTicket(String nombreCliente) {
        return new Ticket(nombreCliente, new Date(), carritoCompra);
    }

    public void limpiarCarrito() {
        carritoCompra.clear();
    }

    public void agregarNuevoVehiculo(String marca, String modelo, int anio, double precio) {
        Autos nuevoVehiculo = new Autos(marca, modelo, anio, precio);
        catalogo.agregarVehiculo(nuevoVehiculo);
    }
}
