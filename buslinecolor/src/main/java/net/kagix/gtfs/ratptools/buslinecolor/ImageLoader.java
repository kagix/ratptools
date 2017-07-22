/* (C) 2017 kagix
** Code is heavily based on stackoverflow DOT com
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageLoader {
	private BufferedImage image = null;
 
	public ImageLoader(String fileName) {
		loadImageFile(fileName);
	}

	public BufferedImage getImage() {
		return image;
	}


	private boolean loadImageFile(String fileName) {
		boolean success = false;
		try {
			image = ImageIO.read(new File(fileName));
			if (image.getType() != BufferedImage.TYPE_INT_RGB) {
				BufferedImage convertedImage =
					new BufferedImage(	image.getWidth(null), 
								image.getHeight(null), 
								BufferedImage.TYPE_INT_RGB);
		
				Graphics graphicContext = convertedImage.getGraphics();
				graphicContext.drawImage(image, 0, 0, null);

				image = convertedImage;
				success = true;
			}
		} catch (IOException e) {
			image = null;
			System.out.println("Failed to load PNG file: '" + fileName + "'" );
		}

		return success;
	}

}
