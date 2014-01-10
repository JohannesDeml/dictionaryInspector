package at.johannesdeml.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import at.johannesdeml.dictionary.ScoreCalculation.CalculateConsonantsVowelRatio;
import at.johannesdeml.dictionary.ScoreCalculation.ICalculateScore;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ASCENDING = 0;
		final int DESCENDING = 1;
		
		//parameters
		String fileName = "german.dic";
		double scoreThresholdUpper = 1.0;
		double scoreThresholdLower = 0.8;
		int sorting = DESCENDING;
		
		//Set the method to calculate a score for a word
		ICalculateScore calculationRule = new CalculateConsonantsVowelRatio();
		SearchThroughDictionary dict = new SearchThroughDictionary(calculationRule);
		try {
			ArrayList<Word> best = dict.findBest(fileName, scoreThresholdUpper, scoreThresholdLower);
			if(sorting == ASCENDING) {
				Collections.sort(best);
			} else if(sorting == DESCENDING) {
				Collections.sort(best, Collections.reverseOrder());
			}
			
			for(int i = 0; i<Math.min(1000, best.size()); i++) {
				Word word = best.get(i);
				System.out.format("%d. %s %f \n", i, word.getString(), word.getScore());
			}
			
		} catch (FileNotFoundException e) {
			System.err.format("Couldn't find file %s!", fileName);
		}
		

	}

}
