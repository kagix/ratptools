/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.io.*;
import java.lang.*;
public class PNGLister
{
  public static final String EXTENSION_PNG_LOWER_CASE = ".png";
  public static final String EXTENSION_PNG_UPPER_CASE = ".PNG";
  
  public static File[] listPNGFiles(String folderPath)
  {
    File currentFolder = new File(folderPath); 
    File[] pngFiles = currentFolder.listFiles(
                          new FilenameFilter() 
                          {
                            @Override
                            public boolean accept(File dir, String name) 
                            {
                              return (  name.endsWith(EXTENSION_PNG_LOWER_CASE)
                                      ||name.endsWith(EXTENSION_PNG_UPPER_CASE) );
                            }
                          });
    return pngFiles;
  }
}
