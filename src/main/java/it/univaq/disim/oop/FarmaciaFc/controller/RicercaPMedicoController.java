package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
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

import java.net.URL;
import java.util.ResourceBundle;

public class RicercaPMedicoController implements Initializable, DataInitializable{

    @FXML
    private TextField codiceRicettaT;

    @FXML
    private TextField codiceFiscaleT;

    @FXML
    private Button cerca;

    private ViewDispatcher dispatcher;

    public RicercaPMedicoController(){
        dispatcher=ViewDispatcher.getInstance();}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cerca(ActionEvent action) throws DatabaseException {
        Prescrizione pe = null;
        String cf = null;
        int codice = 0;
        PrescrizioneDao p = new PrescrizioneDao();
        cf = codiceFiscaleT.getText();
        if (cf.equals("")){
            if(codiceFiscaleT.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Compila almeno un campo!");
                alert.showAndWait();
            }
            else{if(codiceRicettaT.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Compila almeno un campo!");
                alert.showAndWait();
            }else {
                try {
                    codice = Integer.parseInt(codiceRicettaT.getText());
                    pe = p.ricercaPrescrizioneID(codice);
                }catch (Exception e)  {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setContentText("Codice errato!");
                    alert.showAndWait();
                }
            }
            }
        }else
        {
            try
            {
                pe = p.ricercaPrescrizioneCF(cf);
            }catch (Exception e)  {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Nome errato!");
                alert.showAndWait();
            }
        }
        if (pe == null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setContentText("Farmaco non trovato!");
            alert.showAndWait();
        }else {
            dispatcher.renderView("dettagliPrescrizioneMedico",pe);
        }
    }

}
