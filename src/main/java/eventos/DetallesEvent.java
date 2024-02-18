package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import view.VentanaCrearVehiculo;

public class DetallesEvent implements ActionListener {
	
	public static HashMap<String, String> hm = null;
	
	public DetallesEvent() {
		hm = new HashMap<String, String>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(VentanaCrearVehiculo.btnAnyadir)) {
			String valor = VentanaCrearVehiculo.textFieldValor.getText();
			String atributo = VentanaCrearVehiculo.textFieldAtributo.getText();
		
			VentanaCrearVehiculo.textFieldValor.setText("");
			VentanaCrearVehiculo.textFieldAtributo.setText("");
			
			hm.put(atributo, valor);
			
		}
	}
	
	public static HashMap<String, String> getDetalles(){
		return hm;
	}
}
