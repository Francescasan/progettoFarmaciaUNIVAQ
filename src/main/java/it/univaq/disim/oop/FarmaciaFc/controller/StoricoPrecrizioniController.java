package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StoricoPrecrizioniController implements Initializable, DataInitializable{

    @FXML
    private TableView storico;

    @FXML
    private TableColumn dataEvasione;

    @FXML
    private TableColumn medico;

    @FXML
    private TableColumn codiceRicetta;

    @FXML
    private TableColumn dataCreazione;

    @FXML
    private Button dettagli;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
