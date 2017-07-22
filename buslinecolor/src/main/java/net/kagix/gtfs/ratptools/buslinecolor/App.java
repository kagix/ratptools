/* (C) 2017 kagix
** 
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

public class App {
	public static final String NO_GUI = "java.awt.headless";
	private Options options;
	private TabReport tabReport = new TabReport();
	private CSVReport csvReport = new CSVReport();

	public static void main( String[] args ) {

		System.setProperty( NO_GUI, "true"); 

		App app = new App( args);
		app.process();
	}

	public App(String[] args) {
		 options = new Options( args);
	}

	public void process() {

		if (   !options.getHelpFlag() 
		    && !options.getTabFlag() 
		    && !options.getCSVFlag() ) {

			Helper.showQuickMessage();

		} else if ( options.getHelpFlag()) {

			Helper.showHelpMessage();

		} else if (   options.getCSVFlag() 
			   || options.getTabFlag() ) {

			this.analyzePNGFiles();

			if (options.getCSVFlag()) {

				this.generateCSVFile();

			} else if (options.getTabFlag()) {

				this.generateTabFile();
			}
		}
	}


	public void generateCSVFile() {
		csvReport.printToScreen();
	}

	public void generateTabFile() {
		tabReport.printToScreen();
	}

		
	public void analyzePNGFiles() {
		File[] files = PNGLister.listPNGFiles(".");
		for (File pngFileName : files) {
			ImageLoader png = new ImageLoader(pngFileName.toString() );
			HistogramCalculator histoCalculator = new HistogramCalculator(png.getImage() );
			Analyzer analyzer = new Analyzer(histoCalculator);
			BusName busName = new BusName(pngFileName.toString());

			busName.processPrefix();
			busName.processSuffix();
			busName.processNightBus();

			KeyRanking rank;
			if ( busName.isNightBus() ) {
				rank = analyzer.getThirdRank();
			} else {
				rank = analyzer.getFirstRank();
			}

			int red = histoCalculator.getRedValue(rank.getKey());
			int green = histoCalculator.getGreenValue(rank.getKey());
			int blue = histoCalculator.getBlueValue(rank.getKey());

			String hexColor = histoCalculator.getHexValue(rank.getKey()); 

			tabReport.addEntry(busName.getName(),red,green,blue,hexColor);
			csvReport.addEntry(busName.getName(),red,green,blue,hexColor);
		}
	}
}
