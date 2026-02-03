package edu.emir.khaled.actividad1.process;

import edu.emir.khaled.actividad1.data.Autos;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Autos> vehiculosEnExhibicion;

    public Catalogo() {
        vehiculosEnExhibicion = new ArrayList<>();
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        vehiculosEnExhibicion.add(new Autos("Toyota", "Corolla", 2023, 25000.00));
        vehiculosEnExhibicion.add(new Autos("Honda", "Civic", 2024, 27000.00));
        vehiculosEnExhibicion.add(new Autos("Ford", "Mustang", 2023, 35000.00));
        vehiculosEnExhibicion.add(new Autos("Chevrolet", "Camaro", 2024, 38000.00));
        vehiculosEnExhibicion.add(new Autos("Nissan", "Sentra", 2023, 22000.00));
        vehiculosEnExhibicion.add(new Autos("BMW", "Serie 3", 2024, 45000.00));
        vehiculosEnExhibicion.add(new Autos("Mercedes", "Clase C", 2023, 48000.00));
        vehiculosEnExhibicion.add(new Autos("Audi", "A4", 2024, 46000.00));
    }

    public List<Autos> getVehiculosEnExhibicion() {
        return vehiculosEnExhibicion;
    }

    public void mostrarCatalogo() {
        System.out.println("=== VEHÍCULOS EN EXHIBICIÓN ===");
        for (int i = 0; i < vehiculosEnExhibicion.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculosEnExhibicion.get(i).toString());
        }
        System.out.println("===============================");
    }

    public Autos obtenerVehiculoPorIndice(int indice) {
        if (indice >= 0 && indice < vehiculosEnExhibicion.size()) {
            return vehiculosEnExhibicion.get(indice);
        }
        return null;
    }

    public int cantidadVehiculos() {
        return vehiculosEnExhibicion.size();
    }

    public void agregarVehiculo(Autos vehiculo) {
        vehiculosEnExhibicion.add(vehiculo);
    }
}
