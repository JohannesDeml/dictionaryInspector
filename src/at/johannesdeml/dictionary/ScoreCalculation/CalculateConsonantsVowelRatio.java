package at.johannesdeml.dictionary.ScoreCalculation;

public class CalculateConsonantsVowelRatio implements ICalculateScore {

	private final String VOWELS = "aeiuoäüö";
	
	@Override
	public double calculateScore(String word) {
		double length = word.length();
		double numOfConstants = length - count(word);
		double ratio = numOfConstants/length;
		return ratio;
	}
	
	private int count(String word) {
		int numOfVowels = 0;
		for(char c : word.toCharArray()) {
			String temp = Character.toString(c).toLowerCase();
			if(VOWELS.indexOf(temp) >= 0) {
				numOfVowels++;
			}
		}
		return numOfVowels;
	}

}
