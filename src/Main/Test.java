package Main;

import java.awt.Dimension;

import Abstraction.ImageLibrary;
import Presentation.TP4;

public class Test {
	public static void main(String args[]) {

		/*
		 * On instancie le modele de l'application de facon independante dans le
		 * main.
		 */
		ImageLibrary imglib = new ImageLibrary();

		/*
		 * On instancie l'interface en lui passant en parametre les donnees du
		 * modele.
		 */
		//IhmTp3Correction f = new IhmTp3Correction(imglib);
		TP4 f = new TP4(imglib);

		f.setLocation(80, 50);
		f.setPreferredSize(new Dimension(800, 600));
		f.pack();
		f.setVisible(true);
		
	}
	
}
