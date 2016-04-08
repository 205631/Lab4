package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.algoritmoAnagramma.AlgoritmoAnagramma;
import it.polito.tdp.anagrammiDAO.ParolaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btmCalcola;

    @FXML
    private TextFlow txtResult;

    @FXML
    private Button btmReset;

    @FXML
    void doCalcolaAnagramma(ActionEvent event) {
    	
    	ParolaDAO p=new ParolaDAO();
    	txtResult.getChildren().clear();
    	String parola=txtParola.getText();
    	
    	AlgoritmoAnagramma a=new AlgoritmoAnagramma(parola);
    	List<String> l=new ArrayList<String>(a.permuta());
    	
    	for(String s:l){
    		//controllare se le parole sono corrette oppure no
    		Text t=new Text(s+"\n");
    		if(p.check(s)==true){
    			t.setFill(Color.BLACK);
    			txtResult.getChildren().add(t);
    		}else{
    			t.setFill(Color.RED);
    			txtResult.getChildren().add(t);
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.getChildren().clear();
    	txtParola.setText("");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btmCalcola != null : "fx:id=\"btmCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btmReset != null : "fx:id=\"btmReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
