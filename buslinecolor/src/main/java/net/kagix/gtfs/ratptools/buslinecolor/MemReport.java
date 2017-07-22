/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;
public  class MemReport
{
  private ArrayList<String> reportLines = new ArrayList<String>();
  public MemReport()
  {
  }

  public void addLine(String line)
  {
    reportLines.add(line);
  }

  public List<String> getReportLines()
  {
    return reportLines;
  }
}
