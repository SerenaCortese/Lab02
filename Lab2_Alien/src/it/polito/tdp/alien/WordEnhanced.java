package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord,String translation){
		this.alienWord = alienWord;
		this.traduzioni = new ArrayList<String>();
		this.addTrad(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord.toLowerCase();
	}
	
	public void addTrad(String parola) {
		if(!traduzioni.contains(parola))
			traduzioni.add(parola);
	}
	
	public String stampaTrad() {
		String stampa="";
		for(String s: traduzioni) {
			stampa+= s+"\n ";
		}
		return stampa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

	public boolean compareWild(String alienWildCard) {
		if(alienWord.matches(alienWildCard))
			return true;
		return false;
	}

	
}
