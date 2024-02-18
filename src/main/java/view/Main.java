package view;

import controller.Gestion;
import dao.VehiculosDAO;

public class Main {
	public static void main(String[] args) {
		try {
			Gestion g = new Gestion();
			VehiculosDAO vhd = new VehiculosDAO();

			VentanaLogin vl = new VentanaLogin(g, vhd);
			vl.setVisible(true);
		}
		catch (Exception e) {
		}
	}
}