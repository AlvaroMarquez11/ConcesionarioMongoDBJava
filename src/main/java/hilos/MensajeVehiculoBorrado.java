package hilos;

import java.awt.Color;

import controller.Gestion;
import dao.VehiculosDAO;
import view.VentanaBorrarVehiculo;
import view.VentanaPrincipal;

public class MensajeVehiculoBorrado extends Thread{

	private VehiculosDAO vd;
	private Gestion g;
	
	public MensajeVehiculoBorrado(VehiculosDAO vd, Gestion g) {
		this.vd = vd;
		this.g = g;
	}

	@Override
	public void run() {
		try {
			if (vd.deleteVehiculo(g)) {
				String mensaje = "Vehículo con matrícula [" + VentanaBorrarVehiculo.comboBoxMatriculas.getSelectedItem().toString()
						+ "] borrado con éxito.";

				VentanaPrincipal.lblConfirmacion.setText(mensaje);
				VentanaPrincipal.panelConfirmación.setVisible(true);
				VentanaPrincipal.lblConfirmacion.setVisible(true);
				VentanaPrincipal.lblConfirmacion.setForeground(Color.black);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				VentanaPrincipal.panelConfirmación.setVisible(false);
				VentanaPrincipal.lblConfirmacion.setVisible(false);
				
			}
			else {
				String mensaje = "No se ha podido borrar el vehículo";

				VentanaPrincipal.lblConfirmacion.setText(mensaje);
				VentanaPrincipal.panelConfirmación.setVisible(true);
				VentanaPrincipal.panelConfirmación.setBackground(Color.red);
				VentanaPrincipal.lblConfirmacion.setForeground(Color.white);
				VentanaPrincipal.lblConfirmacion.setVisible(true);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				VentanaPrincipal.panelConfirmación.setVisible(false);
				VentanaPrincipal.lblConfirmacion.setVisible(false);
			}
		} catch (NullPointerException ex) {
			String mensaje = "No se ha podido borrar el vehículo";

			VentanaPrincipal.lblConfirmacion.setText(mensaje);
			VentanaPrincipal.panelConfirmación.setVisible(true);
			VentanaPrincipal.panelConfirmación.setBackground(Color.red);
			VentanaPrincipal.lblConfirmacion.setForeground(Color.white);
			VentanaPrincipal.lblConfirmacion.setVisible(true);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			VentanaPrincipal.panelConfirmación.setVisible(false);
			VentanaPrincipal.lblConfirmacion.setVisible(false);
		}
	}
	
	
	
}
