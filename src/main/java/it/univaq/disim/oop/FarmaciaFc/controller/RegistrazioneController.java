package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.UtenteNotFoundException;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.UtenteDao;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmacista;
import it.univaq.disim.oop.FarmaciaFc.domain.Medico;
import it.univaq.disim.oop.FarmaciaFc.domain.Paziente;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;

public class RegistrazioneController implements Initializable, DataInitializable{

    @FXML
    private TextField nome;

    @FXML
    private TextField Cognome;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField codiceFiscale;

    @FXML
    private ComboBox tipoUtente;

    @FXML
    private Button Salva;

    @FXML
    private Button Annulla;

    private ViewDispatcher dispatcher;

    public RegistrazioneController() {
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tipoUtente.getItems().addAll(
                "Medico",
                "Paziente",
                "Farmacista"
        );
        tipoUtente.getSelectionModel().selectLast();
    }

    @FXML
    private void salvaAction (ActionEvent event) throws DatabaseException{
        String name = nome.getText();
        String cogn= Cognome.getText();
        String uname = username.getText();
        String pword = String.valueOf(password.getText());
        String tipo = (String) tipoUtente.getValue();
        String cFiscale = codiceFiscale.getText();
        boolean verifica=true;
        while (verifica) {
            verifica=verificaCampi(name,cogn,uname,pword,cFiscale);
            if(verifica){
                verifica=false;
            UtenteDao aggiunta= new UtenteDao();
            boolean exists = aggiunta.checkUsername(uname);
            if (!exists) {
                if(tipo.equals("Medico")){
                    Medico nutente=new Medico();
                    nutente.setNome(name);
                    nutente.setCognome(cogn);
                    nutente.setUsername(uname);
                    nutente.setPassword(pword);
                    aggiunta.register(nutente);
                }else{ if(tipo.equals("Paziente")){
                    Paziente nutente=new Paziente();
                    nutente.setNome(name);
                    nutente.setCognome(cogn);
                    nutente.setUsername(uname);
                    nutente.setPassword(pword);
                    nutente.setCodiceFiscale(cFiscale);
                    aggiunta.register(nutente);
                }
                else{ if(tipo.equals("Farmacista")){
                    Farmacista nutente=new Farmacista();
                    nutente.setNome(name);
                    nutente.setCognome(cogn);
                    nutente.setUsername(uname);
                    nutente.setPassword(pword);
                    aggiunta.register(nutente);
                }}}
            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Username già utilizzato");
                alert.setContentText("L'username inserito è già utilizzato!");
                alert.showAndWait();
            }
        }}}

    // metodo per verificare che tutti i campi siano compilati
    public boolean verificaCampi(String nome, String Cognome, String username, String password, String codiceFiscale) {
        boolean verifica = true;
        if (nome.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Inserisci il tuo nome!");
            alert.showAndWait();
            verifica = false;
        }
        else if (Cognome.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Inserisci il tuo cognome!");
            alert.showAndWait();
            verifica = false;
        }
        else if (username.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Inserisci il tuo username!");
            alert.showAndWait();
            verifica = false;
        }
        else if (password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Inserisci una password!");
            alert.showAndWait();
            verifica = false;
        }
        else if (codiceFiscale.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Inserisci il tuo codice fiscale!");
            alert.showAndWait();
            verifica = false;
        }
        return verifica;
    }

    //annullamento riporta alla sezione di login
    @FXML
    private void annullaAction(ActionEvent event) {
        dispatcher.logout();
    }
}
