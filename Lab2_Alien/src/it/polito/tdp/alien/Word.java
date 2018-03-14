package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord.toLowerCase();
		this.translation = translation.toLowerCase();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord.toLowerCase();
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation.toLowerCase();
	}

	@Override
	public boolean equals(Object altro) {
		Word w= (Word)altro;
		if(alienWord.equalsIgnoreCase(w.getAlienWord())) {
			return true;
		}else return false;
	}
	
	

}
