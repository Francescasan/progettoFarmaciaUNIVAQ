package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
public class RifornimentoFarmacoController implements Initializable, DataInitializable<Farmaco>{

    @FXML
    private Text nome;

    @FXML
    private TextField quantitadd;

    @FXML
    private Text quanti;

    @FXML
    private Button salva;

    @FXML
    private Button annulla;

    private ViewDispatcher dispatcher;

    public RifornimentoFarmacoController(){
        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initializeData(Farmaco farmaco) {
        this.nome.setText(String.valueOf(farmaco.getNomeFarmaco()));
        this.quanti.setText(String.valueOf(farmaco.getDisponibilita()));
    }

    public void salva(ActionEvent event) throws  DatabaseException{
        String nomep=nome.getText();
        Integer quantitaD=Integer.parseInt(quanti.getText());
        Integer quantitaAD=0;
        if (!quantitadd.getText().equals(""))
        {
            quantitaAD=Integer.parseInt(quantitadd.getText());
            if (quantitaAD >0){
                quantitaD += quantitaAD;
                FarmacoDao f=new FarmacoDao();
                f.addQuantita(nomep,quantitaD);
            }
            else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("Campi non compilati correttamente");
                alert.showAndWait();
            }
        }
        else  {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setContentText("Campi non compilati correttamente");
            alert.showAndWait();
        }
        dispatcher.renderView("farmacoAmministratore");
    }

    public void annulla(ActionEvent event) {
        dispatcher.renderView("farmacoAmministratore");
    }
}
