package it.univaq.disim.oop.FarmaciaFc.controller;

import com.sun.javafx.charts.Legend;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class FarmaciController implements Initializable, DataInitializable{

    @FXML
    private TableView <Farmaco> ricercaFarmaci;

    @FXML
    private TableColumn nomeFarmaco;

    @FXML
    private TableColumn codiceFarmaco;

    @FXML
    private TableColumn casaFarmaceutica;

    @FXML
    private TableColumn disponibilita;

    @FXML
    private Button dettagli;

    @FXML
    private TextField nomeFarmacoT;

    @FXML
    private TextField codFarmacoT;

    @FXML
    private Button cerca;

    @FXML
    private Button operazioni;

    private ViewDispatcher dispatcher;

    public FarmaciController(){
        dispatcher=ViewDispatcher.getInstance();}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FarmacoDao fa=new FarmacoDao();
            nomeFarmaco.setCellValueFactory(new PropertyValueFactory( "nomeFarmaco"));
            codiceFarmaco.setCellValueFactory(new PropertyValueFactory( "id"));
            casaFarmaceutica.setCellValueFactory(new PropertyValueFactory( "casaFarmaceutica"));
            disponibilita.setCellValueFactory(new PropertyValueFactory( "disponibilita"));
            try {
                ricercaFarmaci.getItems().setAll(fa.listaFarmaci());
            }catch (DatabaseException e )
            {e.printStackTrace();}

        }catch (Exception e) {

        }
    }

    public void dettagli(ActionEvent e) {
        for (Farmaco fa : ricercaFarmaci.getSelectionModel().getSelectedItems()){
            dispatcher.renderView("dettagliFarmaco",fa);
        }
    }
}
