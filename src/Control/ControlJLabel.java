package Control;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Abstraction.ImageLibrary;
import Presentation.TP4;


public class ControlJLabel implements Observer {
	
	private JLabel imageCentre = new JLabel();
	ImageLibrary model = new ImageLibrary();
	
	public ControlJLabel(JLabel jl){
		imageCentre = jl;
		//PAC 
		imageCentre.setIcon(model.getCurrentImage());
		}
	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		ImageLibrary librairie = (ImageLibrary) obs;
		imageCentre.setIcon(librairie.getImage(librairie.getCurrent()));
		
		
	}


	

	}

