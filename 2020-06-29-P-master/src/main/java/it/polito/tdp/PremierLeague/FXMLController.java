/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.PremierLeague.model.Adiacenza;
import it.polito.tdp.PremierLeague.model.Massimo;
import it.polito.tdp.PremierLeague.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnConnessioneMassima"
    private Button btnConnessioneMassima; // Value injected by FXMLLoader

    @FXML // fx:id="btnCollegamento"
    private Button btnCollegamento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinuti"
    private TextField txtMinuti; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMese"
    private ComboBox<Integer> cmbMese; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM1"
    private ComboBox<?> cmbM1; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM2"
    private ComboBox<?> cmbM2; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    private int libero= 0;
    @FXML
    void doConnessioneMassima(ActionEvent event) {
    	
    	if (libero==1) {
    	
    	List<Massimo> conn= model.getConnMax();
    	
    	for( Massimo m: conn)
    	{
    		
    		txtResult.appendText(m.getM1().toString() + " " + m.getM2().toString() + " " + m.getPeso()+ "\n");
    	}
    }}

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	String ris= txtMinuti.getText();
    	
    	if(ris.equals(null))
    	{
    		txtResult.appendText("ERRORE: inserire valore\n");
    		return;
    	}
    	
    	Integer minuti;
    	try {
    	minuti = Integer.parseInt(ris);}catch(NumberFormatException n) {txtResult.appendText("ERRORE: il formato è errato\n");
    	return;}
    	
    	if( minuti<1 || minuti>90)
    	{
    		txtResult.appendText("ERRORE: il minutaggio inserito è troppo piccolo o troppo elevato\n");
    		return;
    	}
    	
    	Integer mese= cmbMese.getValue();
    	
    	if ( mese == null)
    	{
    		txtResult.appendText("ERRORE: scegliere un valore dalla lista\n");
    		return;
    	}
    	
    	model.creaGrafo(minuti, mese );
    	
    	libero=1;
    	
    }

    @FXML
    void doCollegamento(ActionEvent event) {
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConnessioneMassima != null : "fx:id=\"btnConnessioneMassima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCollegamento != null : "fx:id=\"btnCollegamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinuti != null : "fx:id=\"txtMinuti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMese != null : "fx:id=\"cmbMese\" was not injected: check your FXML file 'Scene.fxml'.";        assert cmbM1 != null : "fx:id=\"cmbM1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbM2 != null : "fx:id=\"cmbM2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	cmbMese.getItems().addAll(model.getMese());
  
    }
    
    
}
