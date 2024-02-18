package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.VehiculosDAO;
import view.VentanaBuscarPorTipo;

public class FindByTipoEvent implements ActionListener {

	private VehiculosDAO vd;

	public FindByTipoEvent(VehiculosDAO vd) {
		this.vd = vd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(VentanaBuscarPorTipo.buttonBuscar)) {
			String tipo = VentanaBuscarPorTipo.comboBoxTipo.getSelectedItem().toString();
			ArrayList<String> vehiculos = vd.findVehiculoByTipo(tipo);
			VentanaBuscarPorTipo.textAreaResultado.setText(vehiculos.toString());
		}
	}
}