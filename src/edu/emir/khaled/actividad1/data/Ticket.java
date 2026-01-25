package edu.emir.khaled.actividad1.data;

import java.util.Date;
import java.util.List;

public class Ticket {

    private String nombreCliente;
    private Date fechaTransaccion;
    private List<Autos> vehiculosComprados;
    private double totalPagar;

    public Ticket(String nombreCliente, Date fechaTransaccion, List<Autos> vehiculosComprados) {
        this.nombreCliente = nombreCliente;
        this.fechaTransaccion = fechaTransaccion;
        this.vehiculosComprados = vehiculosComprados;
        this.totalPagar = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Autos auto : vehiculosComprados) {
            total += auto.getPrecio();
        }
        return total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public List<Autos> getVehiculosComprados() {
        return vehiculosComprados;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public String generarTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("=== TICKET DE VENTA ===\n");
        ticket.append("Cliente: ").append(nombreCliente).append("\n");
        ticket.append("Fecha: ").append(fechaTransaccion).append("\n");
        ticket.append("Vehículos comprados:\n");

        for (Autos auto : vehiculosComprados) {
            ticket.append("  - ").append(auto.toString()).append("\n");
        }

        ticket.append("Total a pagar: $").append(String.format("%.2f", totalPagar)).append("\n");
        ticket.append("=======================\n");

        return ticket.toString();
    }
}
