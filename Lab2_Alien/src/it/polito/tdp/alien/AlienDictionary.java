package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	//private List<Word> dizionario;
	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		this.dizionario = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		/*Word w = new Word(alienWord,translation);
		for(Word wtemp: dizionario) {
			if(wtemp.equals(w)) {
				wtemp.setTranslation(w.getTranslation());
				return;
			}
				
		}*/
		
		WordEnhanced w = new WordEnhanced(alienWord,translation);
		for(WordEnhanced wtemp: dizionario) {
			if(wtemp.equals(w)) {
				wtemp.addTrad(translation);
				return;
			}
		}
		
		
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		
		/*for(Word w: dizionario) {
			if(w.getAlienWord().compareToIgnoreCase(alienWord)==0) {
				return w.getTranslation();
			}
		}*/
		
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().compareToIgnoreCase(alienWord)==0) {
				return w.stampaTrad();
			}
		}
		return null;
		
	}
	

}
