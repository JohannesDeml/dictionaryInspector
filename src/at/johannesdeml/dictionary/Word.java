package at.johannesdeml.dictionary;

public class Word implements Comparable<Word>{

	private String string;
	private double score;
	
	public Word(String string, double score) {
		this.string = string;
		this.score = score;
	}
	
	public String getString() {
		return string;
	}


	public void setString(String string) {
		this.string = string;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public int compareTo(Word o) {
		return Double.compare(this.score, o.getScore());
	}
	
	
}
