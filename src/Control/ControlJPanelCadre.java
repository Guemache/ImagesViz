package Control;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BorderFactory;

import Abstraction.ImageLibrary;
import Presentation.JCadre;


public class ControlJPanelCadre implements Observer {
	
	private ImageLibrary model;
	private int index;
	private JCadre cadre;
	
	Vector<JCadre> listeCadre;

	public ControlJPanelCadre(ImageLibrary abstraction, Vector<JCadre> liste){
		
		listeCadre = liste;
		this.model = abstraction;
	}
	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub

		ImageLibrary librairie = (ImageLibrary) obs;
	    this.setIndex(librairie.getCurrent());
	    
	   for(int i=0 ; i<model.getSize(); i++){
	    	
	    	listeCadre.get(i).setBorder(null);
	    }
	    
	    listeCadre.get(model.getCurrent()).setBorder(BorderFactory.createLineBorder(Color.black));
	    

		
	}
	public void setIndex(int index) {
		// TODO Auto-generated method stub
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
}
