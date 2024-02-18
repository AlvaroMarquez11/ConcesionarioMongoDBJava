package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.VehiculosDAO;
import view.VentanaBuscarPorMatricula;

public class FindByMatriculaEvent implements ActionListener {

	private VehiculosDAO vd;

	public FindByMatriculaEvent(VehiculosDAO vd) {
		this.vd = vd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(VentanaBuscarPorMatricula.buttonBuscar)) {
			String matricula = VentanaBuscarPorMatricula.comboBoxMatriculas.getSelectedItem().toString();
			ArrayList<String> doc = vd.findVehiculoByMatriculaPretty(matricula);
			VentanaBuscarPorMatricula.textAreaResultado.setText(doc.toString());
		}
	}
}