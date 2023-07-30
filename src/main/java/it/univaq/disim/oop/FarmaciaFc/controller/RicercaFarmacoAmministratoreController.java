package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RicercaFarmacoAmministratoreController implements Initializable, DataInitializable<Farmaco>{


    @FXML
    private TextField nomeFarmacoT;

    @FXML
    private TextField codFarmacoT;

    @FXML
    private Button cerca;

    private ViewDispatcher dispatcher;
    public RicercaFarmacoAmministratoreController(){
        dispatcher=ViewDispatcher.getInstance();}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cerca(ActionEvent action) throws DatabaseException {
        Farmaco fa = null;
        String nome = null;
        int codice = 0;
        FarmacoDao f = new FarmacoDao();
        nome = nomeFarmacoT.getText();
        if (nome.equals("")){
            if(codFarmacoT.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Compila almeno un campo!");
                alert.showAndWait();
            }
            else{if(codFarmacoT.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Compila almeno un campo!");
                alert.showAndWait();
            }else {
                try {
                    codice = Integer.parseInt(codFarmacoT.getText());
                    fa = f.ricercaFarmacoID(codice);
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
                    fa = f.ricercaFarmacoNome(nome);
                }catch (Exception e)  {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setContentText("Nome errato!");
                    alert.showAndWait();
                }
            }
        if (fa == null){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setContentText("Farmaco non trovato!");
        alert.showAndWait();
        }else {
        dispatcher.renderView("dettagliFarmacoAmministratore",fa);
        }
    }
}
