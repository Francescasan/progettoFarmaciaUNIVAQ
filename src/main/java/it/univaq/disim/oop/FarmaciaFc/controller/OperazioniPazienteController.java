package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class OperazioniPazienteController implements Initializable, DataInitializable{

    @FXML
    private TableView operazioniPaziente;

    @FXML
    private TableColumn nomeMedicinale;

    @FXML
    private TableColumn quantita;

    @FXML
    private TableColumn dosaggio;

    @FXML
    private ListView riferimentoPrescrizione;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
