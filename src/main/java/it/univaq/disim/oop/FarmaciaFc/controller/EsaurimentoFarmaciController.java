package it.univaq.disim.oop.FarmaciaFc.controller;


import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;




public class EsaurimentoFarmaciController implements Initializable, DataInitializable{

    @FXML
    private TableView esaurimento;

    @FXML
    private TableColumn nomeFarmaco;

    @FXML
    private TableColumn casaFarmaceutica;

    @FXML
    private TableColumn disponibilita;

    @FXML
    private TableColumn codiceFarmaco;

    private ViewDispatcher dispatcher;

    public EsaurimentoFarmaciController(){
        dispatcher= ViewDispatcher.getInstance();}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    try {
        FarmacoDao fa=new FarmacoDao();
        nomeFarmaco.setCellValueFactory(new PropertyValueFactory("nomeFarmaco"));
        casaFarmaceutica.setCellValueFactory( new PropertyValueFactory("casaFarmaceutica"));
        disponibilita.setCellValueFactory( new PropertyValueFactory("disponibilita"));
        codiceFarmaco.setCellValueFactory( new PropertyValueFactory("id"));
      try{
          esaurimento.getItems().setAll(fa.esaurimentoFarmaci());
      }
      catch (DatabaseException e){
          e.printStackTrace();
      }
    }catch (Exception e) {

    }
    }
}
