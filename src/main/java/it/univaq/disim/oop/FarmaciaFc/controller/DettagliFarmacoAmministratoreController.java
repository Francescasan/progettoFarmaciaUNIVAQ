package it.univaq.disim.oop.FarmaciaFc.controller;

import com.sun.javafx.geom.BaseBounds;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DettagliFarmacoAmministratoreController implements Initializable, DataInitializable<Farmaco>{

    @FXML
    private Text id;

    @FXML
    private Text disponibilita;

    @FXML
    private Text casaFarmaceutica;

    @FXML
    private Text metodoConservazione;

    @FXML
    private Text nomeFarmaco;

    @FXML
    private Text quantitaMinima;

    @FXML
    private Text tipoContenuto;

    @FXML
    private Text tipoUso;

    @FXML
    private Text effettiIndesiderati;

    @FXML
    private Button elimina;

    @FXML
    private Button modifica;

    @FXML
    private Button rifornimento;

    private Farmaco farmaco;
    private ViewDispatcher dispatcher;

    public DettagliFarmacoAmministratoreController(){

        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initializeData(Farmaco farmaco) {
        this.nomeFarmaco.setText(String.valueOf(farmaco.getNomeFarmaco()));
        this.effettiIndesiderati.setText(String.valueOf(farmaco.getEffettiIndesiderati()));
        this.quantitaMinima.setText(String.valueOf(farmaco.getQuantitaMinima()));
        this.tipoContenuto.setText(String.valueOf(farmaco.getTipoContenuto()));
        this.tipoUso.setText(String.valueOf(farmaco.getTipoUso()));
        this.id.setText(String.valueOf(farmaco.getId()));
        this.disponibilita.setText(String.valueOf(farmaco.getDisponibilita()));
        this.casaFarmaceutica.setText(String.valueOf(farmaco.getCasaFarmaceutica()));
        this.metodoConservazione.setText(String.valueOf((farmaco.getMetodoCoservazione())));
        this.farmaco=farmaco;
    }

    public void elimina(ActionEvent event) throws  DatabaseException{
        FarmacoDao fa= new FarmacoDao();
        fa.elimina(farmaco);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Eliminazione effettuata");
        alert.setHeaderText("Eliminazione  effettuata con successo!");
        alert.showAndWait();
        dispatcher.renderView("farmacoAmministratore");
    }

    public void modifica(ActionEvent event) {
       dispatcher.renderView("modificaFarmacoAmministratore",farmaco);
    }

    public void rifornimento(ActionEvent event) {
        dispatcher.renderView("rifornimentoFarmaco",farmaco);
    }
}
