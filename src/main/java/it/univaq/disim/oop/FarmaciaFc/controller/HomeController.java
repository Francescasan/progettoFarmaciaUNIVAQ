package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable, DataInitializable<Utente> {

	@FXML
	private Label benvenutoLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@Override
	public void initializeData(Utente utente) {
		StringBuilder testo = new StringBuilder();
		testo.append("Benvenuto ");
		testo.append(utente.getNome());
		testo.append(" ");
		testo.append(utente.getCognome());
		benvenutoLabel.setText(testo.toString());
	}
	
}
