package Presentation;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class JCadre extends JPanel{
	
	
	private JLabel icon,nom;
	private int index;
	public JCadre(ImageIcon image,String imageName,int index){
		
		        this.index = index;
				icon = new JLabel();
				icon.setIcon(image);
				//Ajout du texte dans un label
				nom = new JLabel(imageName);	
				this.setLayout(new GridBagLayout());
			    GridBagConstraints gbc = new GridBagConstraints();
			    gbc.gridx = 0;
			    gbc.gridy = 0;
			    gbc.fill = GridBagConstraints.CENTER;
				this.add(icon,gbc);
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.fill = GridBagConstraints.CENTER;
				this.add(nom,gbc);
				//Ajout de l'observateur
				//this.addMouseMotionListener(new ControlJCadre(this),new ControlJPanelCadre(model));
				

   }
	public int getIndex() {
		return this.index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
}