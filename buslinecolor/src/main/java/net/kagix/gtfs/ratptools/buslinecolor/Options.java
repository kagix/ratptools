/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;

public class Options
{
  public static final String ARG_HELP_LONG = "--help";
  public static final String ARG_HELP_SHORT = "-h";
  public static final String ARG_GEN_CSV = "--generate-csv";
  public static final String ARG_GEN_TAB = "--generate-tab";

  private boolean flagGenerateCSVFile;
  private boolean flagGenerateTabFile;
  private boolean flagHelp;

  public Options( String[] args)
  {
     this.reset();
     this.parseCommandLine( args );
  } 
 
  public void reset()
  {
     this.flagGenerateCSVFile = false;
     this.flagGenerateTabFile = false;
     this.flagHelp = false;
  } 

  public void parseCommandLine(String[] args)
  {
    for ( String arg : args) 
    {
      if (  arg.equals(ARG_HELP_LONG) 
          ||arg.equals(ARG_HELP_SHORT)  )
      {
        this.flagHelp = true;
      }

      if ( arg.equals(ARG_GEN_CSV) )
      {
        this.flagGenerateCSVFile = true;
      }

      if ( arg.equals(ARG_GEN_TAB) )
      {
        this.flagGenerateTabFile = true;
      }
    } 
  }

  public boolean getHelpFlag()
  {
    return this.flagHelp;
  }

  public boolean getCSVFlag()
  {
    return this.flagGenerateCSVFile;
  }

  public boolean getTabFlag()
  {
    return this.flagGenerateTabFile;
  }

}


