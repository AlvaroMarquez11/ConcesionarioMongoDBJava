package crud;

import eventos.UpdateEvent;
import model.Vehiculo;
import view.VentanaModificar;

public class UpdateVehiculo {
	public String obtenerMatricula() {
		String matricula = VentanaModificar.comboBoxMatriculas.getSelectedItem().toString();

		return matricula;
	}

	public Vehiculo obtenerVehiculo() {
		Vehiculo v = UpdateEvent.getVehiculo();
		return v;
	}
}
