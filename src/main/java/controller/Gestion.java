package controller;

import crud.DeleteVehiculo;
import crud.UpdateVehiculo;
import eventos.CreateEvent;
import model.Vehiculo;

public class Gestion {

	public Vehiculo addVehiculo() {
		Vehiculo v = CreateEvent.getVehiculo();
		return v;
	}

	public String deleteVehiculo() {
		DeleteVehiculo dv = new DeleteVehiculo();
		return dv.deleteVehiculo();
	}

	public String obtenerMatricula() {
		UpdateVehiculo uv = new UpdateVehiculo();
		return uv.obtenerMatricula();
	}
	
	public Vehiculo obtenerVehiculo() {
		UpdateVehiculo uv = new UpdateVehiculo();
		return uv.obtenerVehiculo();
	}
}