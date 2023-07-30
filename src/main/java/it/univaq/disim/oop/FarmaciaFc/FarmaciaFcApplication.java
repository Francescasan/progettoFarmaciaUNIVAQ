package it.univaq.disim.oop.FarmaciaFc;

import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import it.univaq.disim.oop.FarmaciaFc.view.ViewException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FarmaciaFcApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
			viewDispatcher.loginView(stage);
		} catch (ViewException e) {
			e.printStackTrace();
		}
	}

}
