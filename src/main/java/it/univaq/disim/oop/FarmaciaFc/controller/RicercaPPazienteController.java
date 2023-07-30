package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RicercaPPazienteController implements Initializable, DataInitializable{

    @FXML
    private TextField codiceRicettaT;

    @FXML
    private Button cerca;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}