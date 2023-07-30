package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RicercaPrescrizionePazienteController implements Initializable, DataInitializable{

    @FXML
    private TableView ricPrescrizione;

    @FXML
    private TableColumn codiceRicetta;

    @FXML
    private TableColumn Medico;

    @FXML
    private TableColumn dataCreazione;

    @FXML
    private TableColumn dataEvasione;

    @FXML
    private Button Dettagli;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
