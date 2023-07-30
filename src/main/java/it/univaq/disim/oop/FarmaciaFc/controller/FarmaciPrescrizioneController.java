package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Contenuto;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.domain.Prescrizione;
import it.univaq.disim.oop.FarmaciaFc.domain.Utente;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

public class FarmaciPrescrizioneController implements Initializable, DataInitializable {

    @FXML
    private Button conferma;

    @FXML
    private TextField nomeFarmaco1;

    @FXML
    private TextField codiceFarmaco1;

    @FXML
    private TextField quantita1;

    @FXML
    private TextField dosaggio1;

    @FXML
    private Button annulla;

    @FXML
    private Button addFarmaco;

    private ViewDispatcher dispatcher;

    private int id;

    public FarmaciPrescrizioneController() {
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void conferma(ActionEvent e) throws DatabaseException{
        Contenuto c=new Contenuto();
        PazienteDao paziente=new PazienteDao();

        if (nomeFarmaco1.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci nome farmaco!");
            alert.showAndWait();
        }
        else if(codiceFarmaco1.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci codice farmaco!");
            alert.showAndWait();
        }
        else if(quantita1.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci quantità!");
            alert.showAndWait();
        }
        else if(dosaggio1.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attenzione");
            alert.setContentText("Inserisci dosaggio!");
            alert.showAndWait();
        }
        else {
            ContenutoDao cc = new ContenutoDao();
            cc.inserimentoFarmaco(c);
        }
    }

    public void annulla(ActionEvent e){
        dispatcher.renderView("home");
    }
}
