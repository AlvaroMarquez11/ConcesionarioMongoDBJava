package crud;

import view.VentanaBorrarVehiculo;

public class DeleteVehiculo {

	public String deleteVehiculo() {
		String matricula = VentanaBorrarVehiculo.comboBoxMatriculas.getSelectedItem().toString();

		return matricula;
	}
}
