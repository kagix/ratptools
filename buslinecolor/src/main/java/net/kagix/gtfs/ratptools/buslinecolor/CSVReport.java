/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;

public	class CSVReport {
	MemReport memoryReport = new MemReport();
	public static final  String COLUMN_SEPARATOR = ";";

	public CSVReport() {
	}


	public void addEntry(	String busLine, 
				int red, 
				int green, 
				int blue,
				String hexadecimal) {

		String entry =	alignResults(	busLine,
						Integer.toString(red), 
						Integer.toString(green), 
						Integer.toString(blue), 
						hexadecimal);
		memoryReport.addLine(entry);
	}

	public void printToScreen() {

		String header =	header(	"Bus line", 
					"Best guess red", 
					"Best guess green", 
					"Best guess blue", 
					"Best guess hex value");
		System.out.println(header);

		for (String line : memoryReport.getReportLines()) {
			System.out.println(line);
		}
	}


	public String header( String name, 
			      String bestRed, 
			      String bestGreen, 
			      String bestBlue, 
		 	      String hex) {
		StringBuffer result = new StringBuffer();

		result.append(name );

		result.append( COLUMN_SEPARATOR );
		result.append( bestRed );
		
		result.append( COLUMN_SEPARATOR );
		result.append( bestGreen );
		
		result.append( COLUMN_SEPARATOR );
		result.append( bestBlue );

		result.append( COLUMN_SEPARATOR );
		result.append( hex );

		return result.toString();
	}

	 public String alignResults(	String name,
					String red, 
					String green, 
					String blue, 
					String hex) {

		StringBuffer result = new StringBuffer();

		result.append(name);

		result.append( COLUMN_SEPARATOR );
		result.append(red);

		result.append( COLUMN_SEPARATOR );
		result.append(green);

		result.append( COLUMN_SEPARATOR );
		result.append(blue);

		result.append( COLUMN_SEPARATOR );
		result.append(hex);

		return result.toString();
	}

}
