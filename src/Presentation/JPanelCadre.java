package Presentation;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelCadre extends JPanel {
	public JPanelCadre(){
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 1), "Vignettes"));

		
	}

}
