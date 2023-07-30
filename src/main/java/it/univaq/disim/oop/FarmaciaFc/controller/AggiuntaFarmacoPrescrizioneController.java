package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class AggiuntaFarmacoPrescrizioneController implements Initializable, DataInitializable{

    @FXML
    private TextField nomeFarmaco;

    @FXML
    private TextField codiceFarmaco;

    @FXML
    private TextField quantita;

    @FXML
    private TextField dosaggio;

    @FXML
    private Button conferma;

    @FXML
    private Button annulla;

    @FXML
    private Button addFarmaco;

    @FXML
    private Label idPrescrizione;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
