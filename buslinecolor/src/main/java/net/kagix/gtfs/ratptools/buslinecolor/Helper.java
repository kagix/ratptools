/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;

public class Helper
{

  public static void showQuickMessage()
  {
    
    StringBuffer quickMessage = new StringBuffer();

    quickMessage.append("\n");
    quickMessage.append("Please execute: java -jar <jar-name> ");
    quickMessage.append(Options.ARG_HELP_SHORT);
    quickMessage.append("\n");

    System.out.println(quickMessage.toString());
  }  

  public static void showHelpMessage() 
  {
    StringBuffer helpMessage = new StringBuffer();

    helpMessage.append("\n");
    helpMessage.append("Please execute: java -jar <jar-name> ");
    helpMessage.append("["); 
    helpMessage.append(Options.ARG_HELP_SHORT);
    helpMessage.append("|"); 
    helpMessage.append(Options.ARG_HELP_LONG);
    helpMessage.append("]"); 
    helpMessage.append("["); 
    helpMessage.append( Options.ARG_GEN_CSV);
    helpMessage.append("]"); 
    helpMessage.append("["); 
    helpMessage.append( Options.ARG_GEN_TAB );
    helpMessage.append("]"); 
    helpMessage.append("\n"); 

    helpMessage.append("This tool needs to be run in a folder with the .PNG image files from RATB. ");
    helpMessage.append("You can download the official zip file from: ");
    helpMessage.append("'https://data.ratp.fr/explore/?sort=modified' ");
    helpMessage.append("Look for the section 'Indice des lignes de bus du réseau RATP'. ");
    helpMessage.append("There search for section 'Pièces jointes'. ");
    helpMessage.append("You will find the ZIP file 'indices.zip'. ");
    helpMessage.append("The ZIP file contains the PNG images.");

    helpMessage.append("\n\n");

    System.out.println(helpMessage.toString());
  }
}


