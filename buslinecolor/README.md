# Module Bus Line Color

This module extracts the RGB (RVB) values frm the official bus line images.

## Recall commands 

mvn archetype:generate -DgroupId=net.kagix.gtfs.ratptools -DartifactId=buslinecolor

mvn package


## Data to which the tool applies

This tool needs to be run in a folder with the .PNG image files from RATP.
You can download the official zip file from: 
'https://data.ratp.fr/explore/?sort=modified' 
Look for the section 'Indice des lignes de bus du réseau RATP'. 
There search for section 'Pièces jointes'. 
You will find the ZIP file 'indices.zip'. 
The ZIP file contains the PNG images.
