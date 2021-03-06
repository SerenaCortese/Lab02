package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary dizi = new AlienDictionary();
	
	
	
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	//txtResult.setText("Welcome to Alien Dictionary v2018! ");
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
	    	String s= txtWord.getText();
	    	
	    	//controllo sull'input
	    	if (s == null || s.length() == 0) {
				txtResult.setText("Inserire una o due parole.");
				return;
			}
    	    
    	    if(s.matches("[A-Za-z? ]*")==false) {
    	    	txtResult.appendText("ERRORE: Sono ammessi solo caratteri alfabetici e/o spazio!\n");
    	    	txtWord.clear();
    	    	return;
    	    }
    	    
    	    String[] array = s.split(" ");
    	    
    	    if(array.length==2) {
    	    	//inserire parola nel dizionario
    	    	String aliena = array[0];
        	    String traduzione= array[1];
        	    
        	    dizi.addWord(aliena, traduzione);
        	    txtResult.setText("La parola: \"" + aliena + "\", con traduzione: \"" + traduzione + "\", � stata inserita nel dizionario.");
        	    txtWord.clear();
    	    }else if(array.length==1){
    	    	//traduci parola
    	    	String parola = array[0];
    	    	String traduzione; 
    	    	
    	    	if(parola.matches("[a-zA-Z?]*") && !parola.matches("[a-zA-Z]*")) {
    	    		traduzione = dizi.tradWildCard(parola);
    	    	}else {
    	    		traduzione = dizi.translateWord(parola);
        	    	
    	    	}
    	    	
    	    	
    	    	if(traduzione!=null) {
    	    		txtResult.setText("La traduzione della parola "+ parola +" �: "+traduzione+".\n");
    	    	}else {
    	    		txtResult.setText("La parola cercata non esiste nel dizionario.");
    	    	}
    	    	txtWord.clear();
    	    }else {
    	    	//messaggio errore
    	    	txtResult.setText("ERRORE: Hai inserito troppe parole.\n");
    	    }
    	    
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	dizi.resetDictionary();
    }
    
}
