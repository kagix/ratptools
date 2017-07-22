/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
public  class BusName
{
  private String name;
  private boolean nightBusFlag;

  public BusName(String pngFileName)
  {
    name = pngFileName;
    nightBusFlag = false;
  }

  public String getName()
  {
    return name;
  }

  public boolean isNightBus()
  {
    return nightBusFlag;
  }

  public void processPrefix()
  {
    String localName = name;
    if ( localName.startsWith("./"))
    {
      localName = localName.replace("./","");
    }

    if ( localName.startsWith(".\\"))
    {
      localName = localName.replace(".\\","");
    }
    name = localName;
  }


  public void processSuffix()
  {
    String localName = name;
    if ( localName.indexOf("-gen") >=0)
    {
      localName = localName.substring(0,localName.indexOf("-gen"));
    } 

    if ( localName.indexOf("gen") >=0)
    {
      localName = localName.substring(0,localName.indexOf("gen"));
    } 
    name = localName;
  }

  public void processNightBus()
  {
    String localName = name;
    if ( localName.startsWith("Noct-") )
    {
        localName = localName.replace("Noct-","N");
        nightBusFlag = true;
    }
    name = localName;
  }
}
