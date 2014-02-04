package Presentation;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import Abstraction.ImageLibrary;
import Control.*;

@SuppressWarnings("serial")
public class TP4 extends JFrame {

	ImageLibrary model;

	int currentCadre;

	//simplifie le code de construction de la JFrame
	final Container pane = this.getContentPane();
	private JPanel panCentre;
	private JPanelCadre panBas;
	@SuppressWarnings("rawtypes")
	private JList listeImages;
	private JSlider slider;
	private JLabel imageCentre;
	
	private JMenuBar menu;
	private JMenu file;
	private Vector<String> imagesListe;

	/**
	 * on declare en donnee membres les composants importants de l interface qui
	 * vont servir a plusieurs endroits
	 */
	
	// TODO 
		
	public TP4(ImageLibrary imglib) {

		// TODO : A CHANGER !!!!
		setTitle("GUEMACHE LARBI (G1)");
		
		// on conserve la reference du modele de bibliotheque d Images
		model = imglib;

		// JFrame organisee en BorderLayout
		pane.setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});

		BuildCentre();
		BuildSlider();
		BuildBas();
		BuildListe();		
		BuildMenu();		

	}
	/**
	 * Question 4.1.2 : La vue (IHM)
	 */

	/**
	 * A : Afficher l'image courante
	 */
	void BuildCentre() {
		/**
		 * JPanel central contenant le JLabel (et donc l image)
		 */
		panCentre = new JPanel();
		panCentre.setLayout(new BorderLayout());
		//MVC
		//imageCentre = new JLabel(model.getCurrentImage());
		//PAC
		imageCentre = new JLabel();
		imageCentre.setHorizontalAlignment(JLabel.CENTER);
		imageCentre.setVerticalAlignment(JLabel.CENTER);
		//
		//
		//Ajout de la barre de navigation
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	  	JScrollPane scroll1 = new JScrollPane(imageCentre,v1,h1);
	  	panCentre.add(scroll1,BorderLayout.CENTER);
	  	//
	  	//
		//Ajout de l'observateur
		model.addObserver(new ControlJLabel(imageCentre));
	    this.getContentPane().add(panCentre,BorderLayout.CENTER);
		
		// TODO
	}
	
	/**
	 * B : Bandeau des images dans la partie basse
	 */
	void BuildBas() {
		// TODO
		Vector<JCadre> listeCadres = new Vector<JCadre>();
		panBas = new JPanelCadre();
		JPanel panVig = new JPanel();
		//Panneau qui contient les vignettes
		panVig.setLayout(new FlowLayout());
		panBas.add(panVig);
		for (int i=0; i<model.getSize(); i++)
		{
			 JCadre cadre = new JCadre(model.getImage(i).getIcon(),model.getImage(i).getName(),i);
			

			listeCadres.add(cadre);
			panVig.add(cadre);
			cadre.addMouseMotionListener(new ControlJCadre(model,listeCadres));
			
		}
		
		//Ajout d'une barre de navigation
		JScrollPane scroll = new JScrollPane(panBas);					
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	    this.getContentPane().add(scroll,BorderLayout.SOUTH);	
	    //
	    //Ajout d'un observateur
	    model.addObserver(new ControlJPanelCadre(model,listeCadres));
	}


	/**
	 *  C : Le slider de redimensionnement
	 */
	void BuildSlider() {
		// TODO
		slider = new JSlider();
		slider.setOrientation(1);
		slider.setMaximum(300);
		slider.setMinimum(0);
		slider.setValue(100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(100);
		slider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 1), "Zoom"));
		pane.add(slider,BorderLayout.EAST);
		//
		//
		//Ajout des observateurs
		model.addObserver(new ControlJSlider(this,model));
		slider.addChangeListener(new ControlJSlider(this,model));
		
	}

	/**
	 *  D : La liste sur la gauche
	 */
	@SuppressWarnings("unchecked")
	void BuildListe(){
		// TODO
		imagesListe = new Vector<String>();
		for(int i=0;i<model.getSize();i++){
			imagesListe.add(model.getImage(i).getName());
		}
		listeImages = new JList();
		listeImages.setListData(imagesListe);
		//
		//
		//Ajout d'une barre de navigation
		JScrollPane scroll = new JScrollPane(listeImages);					
		this.getContentPane().add(scroll,BorderLayout.WEST);
		//
		//
		listeImages.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 1), "Villes"));
		//
		//
		//Ajout d'observateurs
		model.addObserver(new ControlJList(this,model));
		listeImages.addListSelectionListener(new ControlJList(this,model));
		
		
	}
	/**
	 * Question 4.3 (Optionnelle) : Menu pour ajouter une image
	 */ 
	void BuildMenu() {
		// TODO
		menu = new JMenuBar();
		this.setJMenuBar(menu);
		file = new JMenu("Fichier");
		menu.add(file);
		menu.repaint();
	}
	
	/**
	 * 
	 * Getters et Setters
	 * 
	 */
	/*
	 * 
	 * Getters et setters
	 */


	
	public int getSliderValue() {
		return slider.getValue();
	}

	public void setSliderValue(int value) {
		this.slider.setValue(value);
	}
	

	@SuppressWarnings("rawtypes")
	public JList getListeImages() {
		return listeImages;
	}

	public void setListeImages(Vector<String> imagesListe){
		this.imagesListe = imagesListe;
	}
	
	public JLabel getImageCentre() {
		return imageCentre;
	}

	public void setImageCentre(JLabel imageCentre) {
		this.imageCentre = imageCentre;
	}

	 
}