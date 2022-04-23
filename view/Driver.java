package view;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Driver extends Application
{
	private HomePageBenvenuto homePageBenvenuto = new HomePageBenvenuto();
	
    @Override
    public void start(Stage window) {
    	Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        try {
            homePageBenvenuto.start(window, popup);
        } catch (Exception e) {
        	System.err.println("Impossibile caricare l'applicazione");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
