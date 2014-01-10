package at.johannesdeml.dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import at.johannesdeml.dictionary.ScoreCalculation.ICalculateScore;

public class SearchThroughDictionary {

	private ICalculateScore calculator;
	
	public SearchThroughDictionary(ICalculateScore calculator) {
		this.calculator = calculator;
	}
	
	public ArrayList<Word> findBest(String fileName, double scoreThresholdUpper, double scoreThresholdLower) throws FileNotFoundException {
		ArrayList<Word> list = new ArrayList<Word>();
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNextLine()) {
			String currentWord = in.nextLine();
			double score = calculator.calculateScore(currentWord);
			if(score >= scoreThresholdLower && score <= scoreThresholdUpper) {
				list.add(new Word(currentWord, score));
			}
		}
		in.close();
		return list;
	}

}
