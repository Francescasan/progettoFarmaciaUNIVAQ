package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class DettagliFarmacoController implements Initializable, DataInitializable <Farmaco>{

    @FXML
    private Text codFarmaco;

    @FXML
    private Text nomeFarmaco;

    @FXML
    private Text contenuto;

    @FXML
    private Text tipoUso;

    @FXML
    private Text effettiIndesiderati;

    @FXML
    private Button tornaIndietro;

    private Farmaco farmaco;
    private ViewDispatcher dispatcher;

    public DettagliFarmacoController(){
        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initializeData(Farmaco farmaco) {
        this.nomeFarmaco.setText(String.valueOf(farmaco.getNomeFarmaco()));
        this.contenuto.setText(String.valueOf(farmaco.getTipoContenuto()));
        this.effettiIndesiderati.setText(String.valueOf(farmaco.getEffettiIndesiderati()));
        this.tipoUso.setText(String.valueOf(farmaco.getTipoUso()));
        this.codFarmaco.setText(String.valueOf(farmaco.getId()));
        this.farmaco=farmaco;
    }

}
