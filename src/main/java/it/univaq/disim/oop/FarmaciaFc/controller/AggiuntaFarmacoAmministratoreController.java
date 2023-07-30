package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.FarmacoDao;

public class AggiuntaFarmacoAmministratoreController implements Initializable, DataInitializable<Farmaco>{

    @FXML
    private TextField nomeFarmaco;

    @FXML
    private TextField casaFarmaceutica;

    @FXML
    private TextField tipoConservazione;

    @FXML
    private TextField effettiIndesiderati;

    @FXML
    private TextField contenutoConfezione;

    @FXML
    private TextField quantitaDisponibile;

    @FXML
    private TextField quantitaMinima;

    @FXML
    private TextField tipoUso;

    @FXML
    private Button conferma;

    @FXML
    private ViewDispatcher dispatcher;

    public AggiuntaFarmacoAmministratoreController(){

        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void conferma(ActionEvent event) throws DatabaseException {
        Farmaco fa=  new Farmaco();
        String nome=nomeFarmaco.getText();
        String effetti =effettiIndesiderati .getText();
        String contenuto= contenutoConfezione.getText();
        String tipo= tipoUso.getText();
        String casa= casaFarmaceutica.getText();
        String tipoc= tipoConservazione.getText();
        Integer quantita=0;
        Integer minimo=0;
        Boolean errore=false;

        if (!quantitaDisponibile.getText().equals(""))
        {quantita=Integer.parseInt(quantitaDisponibile.getText());
        }
        else  {
            errore=true;
        }
        if (quantitaMinima.getText().equals(""))
        { errore=true;
        }
        else {
            minimo=Integer.parseInt(quantitaMinima.getText());
        }

        if(nome.equals(""))
        {errore=true;
        }
        else if(effetti.equals("")) {
            errore=true;
        }
        else if (contenuto.equals(""))
        {
            errore=true;
        }
        else if (tipo.equals(""))
        {
            errore=true;
        }
        else if (casa.equals(""))
        {
            errore=true;
        }
        else if (tipoc.equals(""))
        {
            errore=true;
        }else if (quantitaDisponibile.getText().equals(""))
        {
            errore=true;

        } else if (quantita <0){
            errore=true;

        }else  if (minimo <0){
            errore=true;
        }

        if(!errore){

            fa.setDisponibilita(quantita);
            fa.setQuantitaMinima(minimo);
            fa.setNomeFarmaco(nome);
            fa.setCasaFarmaceutica(casa);
            fa.setMetodoCoservazione(tipoc);
            fa.setTipoContenuto(contenuto);
            fa.setTipoUso(tipo);
            fa.setEffettiIndesiderati(effetti);
            FarmacoDao f=new FarmacoDao();
            f.inserimentoFarmaco(fa);
            dispatcher.renderView("farmacoAmministratore");}

        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setContentText("Campi non compilati correttamente");
            alert.showAndWait();
        }
    }
}


