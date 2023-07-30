package it.univaq.disim.oop.FarmaciaFc.controller;

import it.univaq.disim.oop.FarmaciaFc.domain.Amministratore;
import it.univaq.disim.oop.FarmaciaFc.domain.Medico;
import it.univaq.disim.oop.FarmaciaFc.domain.Paziente;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmacista;
import it.univaq.disim.oop.FarmaciaFc.domain.Utente;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable, DataInitializable<Utente> {

	private static final MenuElement MENU_HOME = new MenuElement("Home", "home");

	private static final MenuElement[] MENU_AMMINISTRATORE = { new MenuElement("Inserisci nuovo Farmaco", "aggiuntaFarmacoAmministratore") ,
			new MenuElement("Ricerca Farmaco", "ricercaFarmacoAmministratore"),
			new MenuElement("Farmaci Registrati", "farmacoAmministratore"),
			new MenuElement("Farmaci in Esaurimento", "esaurimentoFarmaciAmministratore")};

	private static final MenuElement[] MENU_MEDICO = { new MenuElement("Crea prescrizione", "nuovaPrescrizione") ,
			new MenuElement("Operazioni Prescrizione", "ricercaPMedico"),
			new MenuElement("Elenco Farmaci", "farmaci"),
			new MenuElement("Ricerca Farmaco", "ricercaFarmaco")};

	private static final MenuElement[] MENU_FARMACISTA = { new MenuElement("Prescrizioni", "ricercaPFarmacista")};

	private static final MenuElement[] MENU_PAZIENTE = { new MenuElement("Scheda farmaci", "farmaci"),
			new MenuElement("Ricerca Farmaco", "ricercaFarmaco"),
			new MenuElement("Ricerca Prescrizione", "ricercaPPaziente"),
			new MenuElement("Visualizza Storico", "storicoPrescrizioni") };

	@FXML
	private VBox menuBar;

	private Utente utente;
	private ViewDispatcher dispatcher;
	
	public LayoutController() {

		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	public void initializeData(Utente utente) {
		this.utente = utente;
		menuBar.getChildren().addAll(createButton(MENU_HOME));
		menuBar.getChildren().add(new Separator());

		if (utente instanceof Amministratore) {
			for (MenuElement menu : MENU_AMMINISTRATORE) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		if (utente instanceof Farmacista) {
			for (MenuElement menu : MENU_FARMACISTA) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		if (utente instanceof Medico) {
			for (MenuElement menu : MENU_MEDICO) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		if (utente instanceof Paziente) {
			for (MenuElement menu : MENU_PAZIENTE) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
	}

	@FXML
	public void esciAction(MouseEvent event) {
		dispatcher.logout();
	}

	private Button createButton(MenuElement viewItem) {
		Button button = new Button(viewItem.getNome());
		button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(10);
		button.setPrefWidth(180);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dispatcher.renderView(viewItem.getVista(), utente);
				event.consume();
			}
		});
		return button;
	}
}
