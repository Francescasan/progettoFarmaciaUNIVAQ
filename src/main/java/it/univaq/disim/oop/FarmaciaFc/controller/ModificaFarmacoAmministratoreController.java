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
import java.net.URL;
import java.util.ResourceBundle;

public class ModificaFarmacoAmministratoreController implements Initializable, DataInitializable<Farmaco>{

    @FXML
    private TextField nomeFarmaco;

    @FXML
    private TextField casaFarmaceutica;

    @FXML
    private TextField quantitaMinima;

    @FXML
    private TextField tipoConservazione;

    @FXML
    private TextField quantitaDisponibile;

    @FXML
    private TextField contenutoConfezione;

    @FXML
    private TextField tipoUso;

    @FXML
    private TextField effettiIndesiderati;

    @FXML
    private Button salva;

    @FXML
    private Button annulla;

    private int id;
    private ViewDispatcher dispatcher;

    public ModificaFarmacoAmministratoreController(){

        dispatcher=ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initializeData(Farmaco farmaco) {
        this.nomeFarmaco.setText(String.valueOf(farmaco.getNomeFarmaco()));
        this.effettiIndesiderati.setText(String.valueOf(farmaco.getEffettiIndesiderati()));
        this.quantitaMinima.setText(String.valueOf(farmaco.getQuantitaMinima()));
        this.contenutoConfezione.setText(String.valueOf(farmaco.getTipoContenuto()));
        this.tipoUso.setText(String.valueOf(farmaco.getTipoUso()));
        this.quantitaDisponibile.setText(String.valueOf(farmaco.getDisponibilita()));
        this.casaFarmaceutica.setText(String.valueOf(farmaco.getCasaFarmaceutica()));
        this.tipoConservazione.setText(String.valueOf(farmaco.getMetodoCoservazione()));
        this.id= farmaco.getId();
    }

    public void salva(ActionEvent event) throws  DatabaseException{
    Farmaco fa= new Farmaco();
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
        {
            errore=true;
        }
        else if(effetti.equals(""))
        {
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
        }
        else if (quantitaDisponibile.getText().equals(""))
        {
            errore=true;
        }
        else if (quantita <0)
        {
            errore=true;
        }
        else  if (minimo <0)
        {
            errore=true;
        }
        if(!errore){
            fa.setId(id);
            fa.setDisponibilita(quantita);
            fa.setQuantitaMinima(minimo);
            fa.setNomeFarmaco(nome);
            fa.setCasaFarmaceutica(casa);
            fa.setMetodoCoservazione(tipoc);
            fa.setTipoContenuto(contenuto);
            fa.setTipoUso(tipo);
            fa.setEffettiIndesiderati(effetti);
            FarmacoDao f=new FarmacoDao();
            f.modifica(fa);}
        else{
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