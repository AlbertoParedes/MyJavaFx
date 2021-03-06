package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * A <b>JavaFX</b> interface with a nice look and simple functionality 
 * @author ernesto
 * @version 1.0
 * @see OneController
 */

public class Main extends Application {
	
	private AnchorPane rootLayout;	
	/**
	 * my Stage is public
	 */
	public static Stage primaryStage;


	
	/**
	 * sets the stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AID School");
			this.primaryStage.setX(screenSize.getWidth()/7);   
			this.primaryStage.setY(screenSize.getHeight()/7);

			primaryStage.show();
			
			initRootLayout();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * loads the layout
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Layouts.fxml"));
			rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			//Scene scene = new Scene(rootLayout, 700,600);
			Scene scene = new Scene(rootLayout);
			Image image = new Image("application/view/images/batman-logo.png");  //pass in the image path
			scene.setCursor(new ImageCursor(image));
//			scene.setCursor(Cursor.CROSSHAIR); //Change cursor to crosshair
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
			//			adding fonts
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Shadows+Into+Light");
            Font.loadFont(getClass().getResourceAsStream("../resources/fonts/HipsterishFontNormal.ttf"), 20);
            
            primaryStage.setMinWidth(760);
            primaryStage.setMinHeight(506);
//            primaryStage.sizeToScene();
            
			primaryStage.setScene(scene);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args launching 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
