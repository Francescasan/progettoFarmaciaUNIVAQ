package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.business.impl.UtenteNotFoundException;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.UtenteDao;
import it.univaq.disim.oop.FarmaciaFc.domain.Utente;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, DataInitializable<Object> {

	@FXML
	private Label  loginErrorLabel;

	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private Button loginButton;

	@FXML
	private Button registrati;

	private ViewDispatcher dispatcher;

	public LoginController() {
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginButton.disableProperty().bind(username.textProperty().isEmpty().or(password.textProperty().isEmpty()));
	}

	@FXML
	private void loginAction(ActionEvent event) {

		String username_ = username.getText();
		String password_ = String.valueOf(password.getText());

		try {
			UtenteDao ud = new UtenteDao();
			Utente utente = ud.authenticate(username_, password_);
			dispatcher.loggedIn(utente);
		} catch (UtenteNotFoundException e) {
			loginErrorLabel.setText("Username e/o password errati!");
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void regAction(ActionEvent event) {
    dispatcher.registrazione();
    }

}
