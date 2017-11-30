package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * The only controller for the whole application.
 * 
 * @author ernesto
 */
public class OneController {
	
	@FXML
    private Button btSuper;

    @FXML
    private Button btBatman;

    @FXML
    private Button btSpider;

    @FXML
    void chancheCursor(MouseEvent event) {
    		String id = event.getSource().toString();
    		if(id.contains("btSuper")) {
    			Image image = new Image("application/view/images/superman-logo.png");  //pass in the image path
    
    			Main.primaryStage.getScene().setCursor(new ImageCursor(image));
    		}else if(id.contains("btBatman")) {
    			Image image = new Image("application/view/images/batman-logo.png");  //pass in the image path
    			Main.primaryStage.getScene().setCursor(new ImageCursor(image));
    		}else if(id.contains("btSpider")) {
    			Image image = new Image("application/view/images/spiderman-logo.png");  //pass in the image path
    			Main.primaryStage.getScene().setCursor(new ImageCursor(image));
    		}
    }
	
	@FXML
	public ImageView refugees;

	public AnchorPane page;
	public Scene scene;

	public static Stage sendStage;

	private void initialize() {
		Scene scene = new Scene(page);
		// refugees.setEffect(new GaussianBlur(50));
		// refugees.fitWidthProperty().bind(sendStage.widthProperty());
		refugees.fitWidthProperty().bind(scene.widthProperty());
		refugees.setPreserveRatio(true);
		sendStage.setScene(scene);
		sendStage.show();
	}

	// private void initializeCeiling(AnchorPane root) {
	// ceiling = new Ellipse();
	// ceiling.centerXProperty().bind(root.widthProperty().multiply(0.5));
	// ceiling.centerYProperty().setValue(0);
	// ceiling.radiusXProperty().bind(root.widthProperty().multiply(0.8));
	// ceiling.radiusYProperty().bind(root.heightProperty().multiply(0.6));
	// }

	/**
	 * Opens an stage to send the profile
	 */

	public void showSendProfile() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setController(new SetBlur());
			loader.setLocation(Main.class.getResource("view/Superheader.fxml"));
			page = loader.load();
			
			Stage sendStage = new Stage();
            sendStage.setTitle("Superheader");
            Scene scene = new Scene(page);
            sendStage.setScene(scene);
            this.sendStage = sendStage;
            this.sendStage.show();
            //Main.stage.close();


			// clips

			// );
			//
			// ColorAdjust colorAdjust = new ColorAdjust();
			// colorAdjust.setContrast(1);
			// colorAdjust.setHue(0);
			// colorAdjust.setBrightness(0);
			// colorAdjust.setSaturation(0);
			// // ceiling_image.setEffect(colorAdjust);
			// ceiling_image.setEffect(new GaussianBlur(5));
			// refugees.setClip(ceiling);

			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class SetBlur {

		@FXML
	    private ImageView refugees;

	    @FXML
	    void volver(ActionEvent event) {
	    		Main.primaryStage.show();
	    		OneController.sendStage.close();

	    }
		@FXML
		public void initialize() {
			refugees.setEffect(new GaussianBlur(5));

		}
	}

	@FXML
	private void handleSend() {
		Main.primaryStage.hide();
		showSendProfile();
		// sendStage.close();
	}

	@FXML
	private void handleClose() {

		System.exit(0);
	}
}
