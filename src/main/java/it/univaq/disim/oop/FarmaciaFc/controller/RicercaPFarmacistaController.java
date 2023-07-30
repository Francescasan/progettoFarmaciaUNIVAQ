package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RicercaPFarmacistaController implements Initializable, DataInitializable{

    @FXML
    private TableView operazioniFarmacista;

    @FXML
    private TableView prescrFarmacista;

    @FXML
    private TableColumn nomeFarmaco;

    @FXML
    private TableColumn quantita;

    @FXML
    private TableColumn dosaggio;

    @FXML
    private TableColumn medico;

    @FXML
    private TableColumn evadi;

    @FXML
    private TableColumn modifica;

    @FXML
    private TableColumn codiceFiscale;

    @FXML
    private TableColumn codiceRicetta;

    @FXML
    private TableColumn operazioni;

    @FXML
    private TableColumn dataCreazione;

    @FXML
    private ListView riferimentoPrescrizione;

    @FXML
    private TextField CodiceRicettaT;

    @FXML
    private TextField codiceFiscaleT;

    @FXML
    private Button cerca;

    @FXML
    private Button tornaIndietro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
