package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.PazienteDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.PrescrizioneDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.domain.Prescrizione;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class NuovaPrescrizioneController implements Initializable, DataInitializable{

    @FXML
    private TextField codiceFiscale;

    @FXML
    private TextField nomePaziente;

    @FXML
    private TextField cognomePaziente;

    @FXML
    private Button annulla;

    @FXML
    private ViewDispatcher dispatcher;

    public NuovaPrescrizioneController(){

        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void avanti(ActionEvent e) throws DatabaseException{
        Prescrizione p=new Prescrizione();
        PazienteDao paziente=new PazienteDao();

        if (codiceFiscale.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci paziente!");
            alert.showAndWait();
        }
        else if(cognomePaziente.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci paziente!");
            alert.showAndWait();
        }
        else if(nomePaziente.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci paziente!");
            alert.showAndWait();
        }
            else {
                PrescrizioneDao pe = new PrescrizioneDao();
                pe.inserimentoPrescrizione(p);
            }
        }

        public void annulla(ActionEvent e){
        dispatcher.renderView("home");
        }

}
