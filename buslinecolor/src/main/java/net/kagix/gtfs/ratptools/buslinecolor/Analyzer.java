/* (C) 2017 kagix
** 
*/
package net.kagix.gtfs.ratptools.buslinecolor;
import java.lang.*;
import java.util.*;

public class Analyzer {
	private KeyRanking firstRank = new KeyRanking();
	private KeyRanking secondRank = new KeyRanking();
	private KeyRanking thirdRank = new KeyRanking();

	public Analyzer(HistogramCalculator histoCalculator) {

		firstRank.calculate(histoCalculator,null,null);
		secondRank.calculate(histoCalculator,firstRank,null);
		thirdRank.calculate(histoCalculator,firstRank,secondRank);
	}

	public KeyRanking getFirstRank() {
		return firstRank;
	}

	public KeyRanking getSecondRank() {
		return secondRank;
	}

	public KeyRanking getThirdRank() {
		return thirdRank;
	}
}
