package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Gestion;
import dao.VehiculosDAO;
import hilos.MensajeVehiculoModificado;
import model.Vehiculo;
import view.VentanaModificar;

public class UpdateEvent implements ActionListener {

	private VehiculosDAO vd;
	private Gestion g;
	private static Vehiculo v = null;
	private VentanaModificar vm;

	public UpdateEvent(Gestion g, VehiculosDAO vd, VentanaModificar vm) {
		this.g = g;
		this.vd = vd;
		this.vm = vm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(VentanaModificar.btnModificar)) {
			v = Vehiculo.builder().matricula(VentanaModificar.textFieldMatricula.getText())
					.tipo(VentanaModificar.comboBoxTipo.getSelectedItem().toString())
					.marca(VentanaModificar.textFieldMarca.getText()).build();

			if (!VentanaModificar.textFieldModelo.getText().equals("")) {
				v.setModelo(VentanaModificar.textFieldModelo.getText());
			}
			if ((VentanaModificar.comboBoxAnyo.getSelectedIndex() != -1
					&& VentanaModificar.comboBoxAnyo.getSelectedIndex() != 0)
					&& VentanaModificar.comboBoxAnyo.isVisible() == true) {
				v.setAnyo(Integer.parseInt(VentanaModificar.comboBoxAnyo.getSelectedItem().toString()));
			}
			if ((VentanaModificar.comboBoxMotor.getSelectedIndex() != -1
					&& VentanaModificar.comboBoxMotor.getSelectedIndex() != 0)
					&& VentanaModificar.comboBoxMotor.isVisible() == true) {
				v.setMotor(VentanaModificar.comboBoxMotor.getSelectedItem().toString());
				if (VentanaModificar.comboBoxMotor.getSelectedItem().toString().equalsIgnoreCase("combustion")) {
					motorCombustion();
				} else if (VentanaModificar.comboBoxMotor.getSelectedItem().toString().equalsIgnoreCase("electrico")) {
					motorElectrico();
				} else {
					motorCombustion();
					motorElectrico();
				}
			}
			if ((VentanaModificar.comboBoxTraccion.getSelectedIndex() != -1
					&& VentanaModificar.comboBoxTraccion.getSelectedIndex() != 0)
					&& VentanaModificar.comboBoxTraccion.isVisible() == true
					) {
				v.setTraccion(VentanaModificar.comboBoxTraccion.getSelectedItem().toString());
			}
			if (!VentanaModificar.textFieldLongitud.getText().equalsIgnoreCase("")) {
				v.setLongitud(Double.parseDouble(VentanaModificar.textFieldLongitud.getText()));
			}
			if (!VentanaModificar.textFieldAltura.getText().equalsIgnoreCase("")) {
				v.setAltura(Double.parseDouble(VentanaModificar.textFieldAltura.getText()));
			}
			if (!VentanaModificar.textFieldCapCarga.getText().equalsIgnoreCase("")) {
				v.setCapacidadCarga(Integer.parseInt(VentanaModificar.textFieldCapCarga.getText()));
			}
			if (!VentanaModificar.textFieldEjes.getText().equalsIgnoreCase("")) {
				v.setEjes(Integer.parseInt(VentanaModificar.textFieldEjes.getText()));
			}
			if ((VentanaModificar.comboBoxBallestas.getSelectedIndex() != -1
					&& VentanaModificar.comboBoxBallestas.getSelectedIndex() != 0)
					&& VentanaModificar.comboBoxBallestas.isVisible() == true) {
				v.setBallestas(VentanaModificar.comboBoxBallestas.getSelectedItem().toString());
			}
			if ((VentanaModificar.comboBoxEstructura.getSelectedIndex() != -1
					&& VentanaModificar.comboBoxEstructura.getSelectedIndex() != 0)
				&& VentanaModificar.comboBoxEstructura.isVisible() == true) {
				v.setEstructura(VentanaModificar.comboBoxEstructura.getSelectedItem().toString());
			}

			MensajeVehiculoModificado mvm = new MensajeVehiculoModificado(vd, g);
			mvm.start();
			

			vm.frame.setVisible(false);
		}
	}

	private void motorElectrico() {
		if ((VentanaModificar.comboBoxTipoCarga.getSelectedIndex() != -1
				&& VentanaModificar.comboBoxTipoCarga.getSelectedIndex() != 0)
				&& VentanaModificar.comboBoxTipoCarga.isVisible() == true) {
			v.setModoCarga(VentanaModificar.comboBoxTipoCarga.getSelectedItem().toString());
		}
	}

	private void motorCombustion() {
		if ((VentanaModificar.comboBoxCombustible.getSelectedIndex() != -1
				&& VentanaModificar.comboBoxCombustible.getSelectedIndex() != 0)
				&& VentanaModificar.comboBoxCombustible.isVisible() == true) {
			v.setCombustible(VentanaModificar.comboBoxCombustible.getSelectedItem().toString());
		}
		if (!VentanaModificar.textFieldConsumo.getText().equalsIgnoreCase("")) {
			v.setConsumo(Double.parseDouble(VentanaModificar.textFieldConsumo.getText()));
		}
		if (!VentanaModificar.textFieldCilindros.getText().equalsIgnoreCase("")) {
			v.setCilindros(Integer.parseInt(VentanaModificar.textFieldCilindros.getText()));
		}
	}

	public static Vehiculo getVehiculo() {
		return v;
	}
}
