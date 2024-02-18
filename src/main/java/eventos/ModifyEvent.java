package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import dao.VehiculosDAO;
import view.VentanaModificar;

public class ModifyEvent implements ActionListener {

	private VehiculosDAO vd;

	public ModifyEvent(VehiculosDAO vd) {
		this.vd = vd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (VentanaModificar.comboBoxMatriculas.getSelectedIndex() != -1) {
			VentanaModificar.panel_2.setVisible(true);
			VentanaModificar.panel_3.setVisible(false);

			String matricula = VentanaModificar.comboBoxMatriculas.getSelectedItem().toString();
			VentanaModificar.textFieldMatricula.setText(matricula);

			ArrayList<String> doc = vd.findVehiculoByMatricula(matricula);

			String linea = doc.toString().substring(2);
			linea = linea.substring(0, linea.length() - 2);
			String[] lineasDoc = linea.split(",");

			String[] div = null;
			HashMap<String, String> hm = new HashMap<String, String>();

			int i = 0;
			String[] stringArray = new String[lineasDoc.length * 2];
			for (String str : lineasDoc) {
				div = str.split(":");
				if (div.length > 1) {
					stringArray[i++] = div[0];
					stringArray[i++] = div[1];
				}
			}

			String[] lineasSinComillas = new String[stringArray.length];
			i = 0;
			for (String str : stringArray) {
				if (str.contains("\"")) {
					str = str.substring(1, str.length() - 1);
				}
				lineasSinComillas[i] = str;
				i++;
			}

			for (int j = 0; j < lineasSinComillas.length; j++) {
				hm.put(lineasSinComillas[j++], lineasSinComillas[j]);
			}

			if (hm.containsKey("tipo")) {
				VentanaModificar.comboBoxTipo.setSelectedItem(hm.get("tipo"));
			}
			if (hm.containsKey("marca")) {
				VentanaModificar.textFieldMarca.setText(hm.get("marca"));
			}
			if (hm.containsKey("modelo")) {
				VentanaModificar.textFieldModelo.setText(hm.get("modelo"));
			}
			if (hm.containsKey("longitud")) {
				VentanaModificar.textFieldLongitud.setText(hm.get("longitud"));
			}
			if (hm.containsKey("altura")) {
				VentanaModificar.textFieldAltura.setText(hm.get("altura"));
			}
			if (hm.containsKey("capacidadCarga")) {
				VentanaModificar.textFieldCapCarga.setText(hm.get("capacidadCarga"));
			}
			if (hm.containsKey("anyo")) {
				VentanaModificar.comboBoxAnyo.setSelectedItem(hm.get("anyo"));
			}
			if (hm.containsKey("motor")) {
				VentanaModificar.comboBoxMotor.setSelectedItem(hm.get("motor"));
				if (VentanaModificar.comboBoxMotor.getSelectedItem().equals("combustion")) {
					if (hm.containsKey("combustible")) {
						VentanaModificar.comboBoxCombustible.setSelectedItem(hm.get("combustible"));
					}
					if (hm.containsKey("consumo")) {
						VentanaModificar.textFieldConsumo.setText(hm.get("consumo"));
					}
					if (hm.containsKey("cilindros")) {
						VentanaModificar.textFieldCilindros.setText(hm.get("cilindros"));
					}
					VentanaModificar.comboBoxTipoCarga.setSelectedIndex(0);
				} else if (VentanaModificar.comboBoxMotor.getSelectedItem().equals("electrico")) {
					System.out.println("Prueba");
					VentanaModificar.comboBoxCombustible.setSelectedIndex(-1);
					VentanaModificar.textFieldConsumo.setText("");
					VentanaModificar.textFieldCilindros.setText("");
					if (hm.containsKey("modoCarga")) {
						VentanaModificar.comboBoxTipoCarga.setSelectedItem(hm.get("modoCarga"));
					}
				}

				else if (VentanaModificar.comboBoxMotor.getSelectedItem().equals("hibrido")) {
					if (hm.containsKey("combustible")) {
						VentanaModificar.comboBoxCombustible.setSelectedItem(hm.get("combustible"));
					}
					if (hm.containsKey("consumo")) {
						VentanaModificar.textFieldConsumo.setText(hm.get("consumo"));
					}
					if (hm.containsKey("cilindros")) {
						VentanaModificar.textFieldCilindros.setText(hm.get("cilindros"));
					}
					if (hm.containsKey("modoCarga")) {
						VentanaModificar.comboBoxTipoCarga.setSelectedItem(hm.get("modoCarga"));
					}
				}

			}
			if (hm.containsKey("traccion")) {
				VentanaModificar.comboBoxTraccion.setSelectedItem(hm.get("traccion"));
			}
			if (hm.containsKey("ejes")) {
				VentanaModificar.textFieldEjes.setText(hm.get("ejes"));
			}
			if (hm.containsKey("ballestas")) {
				VentanaModificar.comboBoxBallestas.setSelectedItem(hm.get("ballestas"));
			}
			if (hm.containsKey("estructura")) {
				VentanaModificar.comboBoxEstructura.setSelectedItem(hm.get("estructura"));
			}
		}
	}
}
