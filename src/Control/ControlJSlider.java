package Control;

import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Abstraction.ImageLibrary;
import Presentation.TP4;

public class ControlJSlider implements Observer, ChangeListener {
	
	private ImageLibrary model;
	private TP4 vue;
	
	public ControlJSlider(TP4 presentation,ImageLibrary abstraction){
		model = abstraction;
		vue = presentation;
		vue.repaint();
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		model.scaleCurrentImage((float) vue.getSliderValue());
	}

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		ImageLibrary librairie = (ImageLibrary) obs;
		vue.setSliderValue(librairie.getCurrentScaleFactor());
		vue.getImageCentre().updateUI();

		
	}

}
