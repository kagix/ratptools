/* (C) 2017 kagix
** Some code is heavily based on stackoverflow DOT com
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

public class HistogramCalculator
{
	private HashMap<Integer,Integer> histogram = null;
 
	public HistogramCalculator(BufferedImage image) {

		if (image != null) {
			histogram = new HashMap<Integer,Integer>();
			calculateHistogram(image);
		}
	}

	public HashMap<Integer,Integer> getHistogram() {
		return histogram;
	}

	private int calculateKey(int[] rgb) {
		int key = rgb[Image.RED]   * Image.RED_SHIFT
			 +rgb[Image.GREEN] * Image.GREEN_SHIFT
			 +rgb[Image.BLUE]  * Image.BLUE_SHIFT;
		return key;
	}

	private void addOrIncrementKeyCount( int key) {

		if (!histogram.containsKey(key)) {
			histogram.put(key,0);
		}

		histogram.put(key,histogram.get(key)+1);
	}

	private void processPixel( int[] pixel) {
		int key = calculateKey(pixel);
		
		addOrIncrementKeyCount( key );
	}

	private void calculateHistogram(BufferedImage image) {
		for (int row = 0; row < image.getHeight(null); row++) {
			for (int column = 0; column <image.getWidth(null); column++) {

				int[] pixel = image.getRaster().getPixel( column, 
									  row, 
									  new int[3]);
				processPixel( pixel );
			}
		}
	}


	public int getRedValue(int key) {

		return (key & Image.RED_MASK) / Image.RED_SHIFT;
	}
	
	public int getGreenValue(int key) {

		return (key & Image.GREEN_MASK) / Image.GREEN_SHIFT;
	}
	
	public int getBlueValue(int key) {

		return (key & Image.BLUE_MASK) / Image.BLUE_SHIFT;
	}
	
	public String getHexValue(int key) {

		return String.format("%06X",key);
	}

}
