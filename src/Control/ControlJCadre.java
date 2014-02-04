package Control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.BorderFactory;

import Abstraction.ImageLibrary;
import Presentation.JCadre;
import Presentation.JPanelCadre;

public class ControlJCadre implements MouseMotionListener{
	
	private ImageLibrary model;
	private Vector<JCadre> listeCadres; 
	
	public ControlJCadre(ImageLibrary model , Vector<JCadre> liste){
		this.model = model;
		
		listeCadres = liste;
		
	}
	

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		
		for(int i=0 ; i<listeCadres.size(); i++){
			
			listeCadres.get(i).setBorder(null);
		}
		JCadre j = (JCadre) e.getSource();
		j.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		
		
		this.model.setCurrent(j.getIndex());
	}


}
