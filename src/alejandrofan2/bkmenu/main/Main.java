package alejandrofan2.bkmenu.main;

import javax.swing.SwingUtilities;

import alejandrofan2.bkmenu.components.BebidasFrame;

public class Main {

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new alejandrofan2.bkmenu.components.MenuFrame();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
