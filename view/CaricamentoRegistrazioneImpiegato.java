package view;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Impiegato;
import controller.ControllerCaricamentoRegistrazione;
import controller.ControllerRegistrazioneImpiegato;

public class CaricamentoRegistrazioneImpiegato {
	
	private ControllerCaricamentoRegistrazione	controller;
	private FinestraPopup						finestraErrore;
	private Impiegato nuovoImpiegato;
	
	public CaricamentoRegistrazioneImpiegato(Impiegato nuovoImpiegato) {
		this.nuovoImpiegato = nuovoImpiegato;
	}

    public void start(Stage window, Stage popup) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/registrazioneImpiegato/CaricamentoRegistrazioneImpiegato.fxml"));
        	Parent root = loader.load();
			Scene scene = new Scene(root);
			
			popup.hide();
			popup.setScene(scene);
			
			popup.setTitle("Caricamento in corso...");
			popup.setResizable(false);
			popup.setWidth(600.0);
			popup.setMinWidth(600.0);
			popup.setHeight(300.0);
			popup.setMinHeight(300.0);
			
			popup.show();
			popup.centerOnScreen();
			
			controller = loader.getController();
			controller.setStage(window, popup);
			controller.inizializza(nuovoImpiegato);

        } catch (IOException erroreCaricamento) {
			finestraErrore = new FinestraPopup();
			
			try {
				finestraErrore.start(popup, "Impossibile caricare la finestra di caricamento", erroreCaricamento);
			} catch (Exception e) {
				System.err.println("Impossibile caricare la finestra di finestra di caricamento");
			}
		}
	}
}
