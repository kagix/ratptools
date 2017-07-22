/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;

public abstract class Image {
	public static final int RED = 0;
	public static final int GREEN = 1;
	public static final int BLUE = 2;

	public static final int RED_SHIFT = 65536;
	public static final int GREEN_SHIFT = 256;
	public static final int BLUE_SHIFT = 1;
	
	public static final int RED_MASK = 0xFF0000;
	public static final int GREEN_MASK = 0X00FF00;
	public static final int BLUE_MASK = 0X0000FF;
}
