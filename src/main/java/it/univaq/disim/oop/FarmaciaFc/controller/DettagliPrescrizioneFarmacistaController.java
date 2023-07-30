package it.univaq.disim.oop.FarmaciaFc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DettagliPrescrizioneFarmacistaController implements Initializable, DataInitializable{

    @FXML
    private TableView operazioniFarmacista;

    @FXML
    private TableColumn nomeFarmaco;

    @FXML
    private TableColumn quantita;

    @FXML
    private TableColumn dosaggio;

    @FXML
    private TableColumn medico;

    @FXML
    private Button evadi;

    @FXML
    private Button tornaIndietro;

    @FXML
    private ListView riferimentoPrescrizione;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}