package Control;

import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Abstraction.ImageLibrary;
import Presentation.TP4;

public class ControlJList implements Observer, ListSelectionListener {

	private ImageLibrary model;
	private TP4 vue;

	public ControlJList(TP4 presentation,ImageLibrary abstraction){
		
		model = abstraction;
		vue = presentation;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		model.setCurrent(vue.getListeImages().getSelectedIndex());
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		vue.getListeImages().setSelectedIndex(model.getCurrent());
	}
	
	

}
