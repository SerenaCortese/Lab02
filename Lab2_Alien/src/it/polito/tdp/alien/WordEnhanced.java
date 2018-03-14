package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord,String translation){
		this.alienWord = alienWord;
		this.traduzioni = new ArrayList<>();
		this.addTrad(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord.toLowerCase();
	}
	
	public void addTrad(String parola) {
		traduzioni.add(parola);
	}
	
	public String stampaTrad() {
		String stampa="";
		for(String s: traduzioni) {
			stampa+= s+", ";
		}
		return stampa;
	}

	public boolean equals(Object altro) {
		WordEnhanced w= (WordEnhanced)altro;
		if(alienWord.equalsIgnoreCase(w.getAlienWord())) {
			return true;
		}else return false;
	}
}
