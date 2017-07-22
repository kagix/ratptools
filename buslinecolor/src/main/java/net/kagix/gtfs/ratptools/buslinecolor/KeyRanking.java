/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;

public class KeyRanking {
	private int key = -1;
	private int count = 0; 
	 
	public KeyRanking() {
	}

	public int getKey() {
		return key;
	}

	public int getCount() {
		return count;
	} 


	public void calculate( 	HistogramCalculator histoCalculator, 
				KeyRanking bestRank, 
				KeyRanking secondBestRank) {

		for ( Integer checkedKey : histoCalculator.getHistogram().keySet() ) {
			if (   bestRank != null 
			    && checkedKey == bestRank.getKey() ) {
				continue;
			}

			if (   secondBestRank != null 
			    && checkedKey == secondBestRank.getKey() ) {
				continue;
			}

			if ( histoCalculator.getHistogram().get(checkedKey) > count) {
				key = checkedKey;
				count = histoCalculator.getHistogram().get(checkedKey);
			}
		}
	} 
}


