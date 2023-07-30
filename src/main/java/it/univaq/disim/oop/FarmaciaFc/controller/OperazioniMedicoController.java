package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class OperazioniMedicoController implements Initializable, DataInitializable{

    @FXML
    private TableView operazioniMedico;

    @FXML
    private TableView prescr;

    @FXML
    private TableColumn nomeFarmaco;

    @FXML
    private TableColumn quantità;

    @FXML
    private TableColumn dosaggio;

    @FXML
    private TableColumn elimina;

    @FXML
    private TableColumn modifica;

    @FXML
    private ListView riferimentoPrescrizione;

    @FXML
    private TableColumn codiceFiscale;

    @FXML
    private TableColumn codiceRicetta;

    @FXML
    private TableColumn operazioni;

    @FXML
    private TableColumn dataCreazione;

    @FXML
    private TableColumn EliminaRicetta;

    @FXML
    private TextField CodiceRicettaT;

    @FXML
    private TextField codiceFiscaleT;

    @FXML
    private Button tornaIndietro;

    @FXML
    private Button cerca;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
