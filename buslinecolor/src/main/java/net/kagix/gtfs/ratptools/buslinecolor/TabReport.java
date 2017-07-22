/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;

public	class TabReport {
	MemReport memoryReport = new MemReport();
	public static final  String SPACE = " ";
	public static final  String VERTICAL_LINE = "|";

	public TabReport() {
	}

	public String blankString( int width) {

		StringBuffer result = new StringBuffer();
		int leftover = width;

		while (leftover -- > 0) {
			result.append( SPACE );
		}

		return result.toString();
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

		String header =	alignHeader(	"Bus line", 
						"Best guess", 
						"Best guess hex value");
		System.out.println(header);

		for (String line : memoryReport.getReportLines()) {
			System.out.println(line);
		}
	}

	public String alignLeft( String text, 
				 int width) {

		StringBuffer result = new StringBuffer();
		
		result.append(text);
		result.append( blankString( width - text.length() ) );

		return result.toString();
	}

	public String alignRight(String text, int width) {

		StringBuffer result = new StringBuffer();
		
		result.append( blankString( width - text.length() ) );
		result.append(text);

		return result.toString();
	}

	public String alignCenter(String text, int width) {

		StringBuffer result = new StringBuffer();
		int leftover = width - text.length();

		result.append( blankString( leftover / 2 ) );
		result.append(text);
		result.append( blankString( leftover / 2 ) );
		result.append( blankString( leftover % 2 ) );

		return result.toString();
	}

	public String alignNumber(int number, int width) {

		return alignRight( Integer.toString(number),
				   width);
	}

	public String alignHeader( String name, 
				   String best, 
				   String hex) {
		StringBuffer result = new StringBuffer();

		result.append( VERTICAL_LINE );
		result.append( alignCenter(name,26) );

		result.append( VERTICAL_LINE );
		result.append( alignCenter(best,26) );

		result.append( VERTICAL_LINE );
		result.append( alignCenter(hex,26) );

		result.append( VERTICAL_LINE );

		return result.toString();
	}

	 public String alignResults(	String name,
					String red, 
					String green, 
					String blue, 
					String hex) {

		StringBuffer result = new StringBuffer();

		result.append( VERTICAL_LINE );
		result.append(alignLeft(name,26));

		result.append( VERTICAL_LINE );
		result.append(alignRight(red,8));

		result.append( VERTICAL_LINE );
		result.append(alignRight(green,8));

		result.append( VERTICAL_LINE );
		result.append(alignRight(blue,8));

		result.append( VERTICAL_LINE );
		result.append(alignCenter(hex,26));

		result.append( VERTICAL_LINE );

		return result.toString();
	}

}
