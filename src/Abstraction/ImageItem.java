package Abstraction;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * TP4 : item image
 */

/**
 * Classe qui decrit un element (une image) de la bibliotheque
 */
public class ImageItem extends ImageIcon {

	/**
	 * Constructeur.
	 * 
	 * @param imagename nom que l on veut donner a l image (independant de filename)
	 * @param filename chemin complet du fichier image
	 */
	ImageItem(String imagename, String filename) {
		super(filename);
		original_width = this.getIconWidth();
		original_height = this.getIconHeight();
		original_image = this.getImage();
		current_scalefactor = 1.0f;
		name = new String(imagename);

	}

	/**
	 * Renvoi la taille de l image.
	 * 
	 */
	public Dimension getImageSize() {
		return new Dimension(this.getIconWidth(), this.getIconHeight());
	}

	/**
	 * Permet de recuperer le facteur d echelle de l image
	 */
	public int getScaleFactor() {
		return ((int) (current_scalefactor * static_scale_factor));
	}

	/**
	 * Permet de changer le facteur d echelle de l image
	 */
	public void setScaleFactor(float scalefactor) {
		this.current_scalefactor = Math.min(Math.max(scalefactor
				/ static_scale_factor, static_min_scale), static_max_scale);
	}

	/**
	 * Permet de recuperer le descripteur de l image.
	 */
	public ImageIcon getIcon() {
		float ratio = Math.max(original_width, original_height);

		int icon_x = (int) (ICON_SIZE * (float) original_width / ratio);
		int icon_y = (int) (ICON_SIZE * (float) original_height / ratio);

		/* On cree une nouvelle image aux bonnes dimensions. */
		Image source = original_image;
		BufferedImage buf = new BufferedImage(icon_x, icon_y,BufferedImage.TYPE_INT_ARGB);

		/* On dessine sur le Graphics de l image bufferisee. */
		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, icon_x, icon_y, null);
		g.dispose();

		return (new ImageIcon(buf));

	}

	/**
	 * Permet de recuperer le nom de l image.
	 */
	public String getName() {
		return this.name.substring(0, Math.max(1, name.length() - 4));
	}

	/**
	 * Redimensionne l image.
	 * 
	 * @param factor facteur d echelle du redimensionnement.
	 */
	public void scaleImage(float factor) // Image source, int width, int height)
	{
		setScaleFactor(factor);

		/* On cree une nouvelle image aux bonnes dimensions. */
		Image source = original_image;
		int width = (int) (original_width * current_scalefactor);
		int height = (int) (original_height * current_scalefactor);
		BufferedImage buf = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);

		/* On dessine sur le Graphics de l image bufferisee. */
		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();

		this.setImage(buf);

	}

	private final float static_scale_factor = 100.0f;
	private final float static_min_scale = 0.1f;
	private final float static_max_scale = 5.0f;
	private final float ICON_SIZE = 40.0f;
	private int original_width;
	private int original_height;
	private Image original_image;
	private float current_scalefactor;
	private String name;

}