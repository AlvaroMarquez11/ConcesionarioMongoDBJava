package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Gestion;
import dao.VehiculosDAO;
import hilos.MensajeVehiculoCreado;
import model.Vehiculo;
import view.VentanaCrearVehiculo;

public class CreateEvent implements ActionListener {

	private VehiculosDAO vd;
	private Gestion g;
	private static Vehiculo v = null;
	private VentanaCrearVehiculo vcv;

	public CreateEvent(Gestion g, VehiculosDAO vd, VentanaCrearVehiculo vcv) {
		this.g = g;
		this.vd = vd;
		this.vcv = vcv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(VentanaCrearVehiculo.btnGuardar)) {
				v = Vehiculo.builder().matricula(VentanaCrearVehiculo.textFieldMatricula.getText())
						.tipo(VentanaCrearVehiculo.comboBoxTipo.getSelectedItem().toString())
						.marca(VentanaCrearVehiculo.textFieldMarca.getText()).build();

				if (!VentanaCrearVehiculo.textFieldModelo.getText().equals("")) {
					v.setModelo(VentanaCrearVehiculo.textFieldModelo.getText());
				}
				if (VentanaCrearVehiculo.comboBoxAnyo.getSelectedIndex() != -1) {
					v.setAnyo(Integer.parseInt(VentanaCrearVehiculo.comboBoxAnyo.getSelectedItem().toString()));
				}
				if (VentanaCrearVehiculo.comboBoxMotor.getSelectedIndex() != -1) {
					v.setMotor(VentanaCrearVehiculo.comboBoxMotor.getSelectedItem().toString());
					if (VentanaCrearVehiculo.comboBoxMotor.getSelectedItem().toString().equalsIgnoreCase("combustión")) {
						motorCombustion();
					} else if (VentanaCrearVehiculo.comboBoxMotor.getSelectedItem().toString()
							.equalsIgnoreCase("eléctrico")) {
						motorElectrico();
					} else {
						motorCombustion();
						motorElectrico();
					}
				}
				if (VentanaCrearVehiculo.comboBoxTraccion.getSelectedIndex() != -1) {
					v.setTraccion(VentanaCrearVehiculo.comboBoxTraccion.getSelectedItem().toString());
				}
				if (!VentanaCrearVehiculo.textFieldLongitud.getText().equalsIgnoreCase("")) {
					v.setLongitud(Double.parseDouble(VentanaCrearVehiculo.textFieldLongitud.getText()));
				}
				if (!VentanaCrearVehiculo.textFieldAltura.getText().equalsIgnoreCase("")) {
					v.setAltura(Double.parseDouble(VentanaCrearVehiculo.textFieldAltura.getText()));
				}
				if (!VentanaCrearVehiculo.textFieldCapCarga.getText().equalsIgnoreCase("")) {
					v.setCapacidadCarga(Integer.parseInt(VentanaCrearVehiculo.textFieldCapCarga.getText()));
				}
				if (!VentanaCrearVehiculo.textFieldEjes.getText().equalsIgnoreCase("")) {
					v.setEjes(Integer.parseInt(VentanaCrearVehiculo.textFieldEjes.getText()));
				}
				if (VentanaCrearVehiculo.comboBoxBallestas.getSelectedIndex() != -1) {
					v.setBallestas(VentanaCrearVehiculo.comboBoxBallestas.getSelectedItem().toString());
				}
				if (VentanaCrearVehiculo.comboBoxEstructura.getSelectedIndex() != -1) {
					v.setEstructura(VentanaCrearVehiculo.comboBoxEstructura.getSelectedItem().toString());
				}

				MensajeVehiculoCreado mvc = new MensajeVehiculoCreado(vd, g);
				mvc.start();

				vcv.frame.setVisible(false);
			}
		}
		catch(NumberFormatException ex) {
			VentanaCrearVehiculo.lblNewLabel.setText("Error al añadir el vehiculo");
			VentanaCrearVehiculo.lblNewLabel.setVisible(true);
		}
	}

	private void motorElectrico() {
		if (VentanaCrearVehiculo.comboBoxTipoCarga.getSelectedIndex() == 0) {
			v.setModoCarga(VentanaCrearVehiculo.comboBoxTipoCarga.getSelectedItem().toString());
		}
	}

	private void motorCombustion() {
		if (VentanaCrearVehiculo.comboBoxCombustible.getSelectedIndex() == 0) {
			v.setCombustible(VentanaCrearVehiculo.comboBoxCombustible.getSelectedItem().toString());
		}
		if (!VentanaCrearVehiculo.textFieldConsumo.getText().equalsIgnoreCase("")) {
			v.setConsumo(Double.parseDouble(VentanaCrearVehiculo.textFieldConsumo.getText()));
		}
		if (!VentanaCrearVehiculo.textFieldCilindros.getText().equalsIgnoreCase("")) {
			v.setCilindros(Integer.parseInt(VentanaCrearVehiculo.textFieldCilindros.getText()));
		}
	}

	public static Vehiculo getVehiculo() {
		return v;
	}
}
