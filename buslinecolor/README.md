# Module Bus Line Color

This module extracts the RGB (RVB) values frm the official bus line images.

## Recall commands 

mvn archetype:generate -DgroupId=net.kagix.gtfs.ratptools -DartifactId=buslinecolor

mvn package

Will generate the jar file ./target/buslinecolor-1.0-SNAPSHOT.jar, called below <jar-name>  

## Data to which the tool applies

This tool needs to be run in a folder with the .PNG image files from RATP.
You can download the official zip file from: 
'https://data.ratp.fr/explore/?sort=modified' 
Look for the section 'Indice des lignes de bus du réseau RATP'. 
There search for section 'Pièces jointes'. 
You will find the ZIP file 'indices.zip'. 
The ZIP file contains the PNG images.

## First use of the tool

java -jar <jar-name> ARGS

If no arguments provided, it will print a short help message:

Please execute: java -jar <jar-name> -h

The -h switch activates the help message:

java -jar <jar-name> [-h|--help][--generate-csv][--generate-tab]


## How to use the tool and generate tabular reports

cd <the folder with PNG image files>

java -jar <path to jar-name> --generate-tab

Report below:

|         Bus line         |        Best guess        |   Best guess hex value   |

|574-TUC-E                 |     130|     220|     115|          82DC73          |

|76                        |     100|       0|     130|          640082          |

|N11                       |     255|      90|       0|          FF5A00          |


## How to use the tool and generate tabular reports

cd <the folder with PNG image files>

java -jar <path to jar-name> --generate-csv

Report below:
 
Bus line;Best guess red;Best guess green;Best guess blue;Best guess hex value

574-TUC-E;130;220;115;82DC73

76;100;0;130;640082

N11;255;90;0;FF5A00


