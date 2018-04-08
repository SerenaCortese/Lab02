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
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		*/
		
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
	
	public void resetDictionary() {
		dizionario.clear();
	}

	public String tradWildCard(String alienWildCard) {
		
		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (WordEnhanced w : dizionario) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.stampaTrad() + "\n");
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}
	

}
