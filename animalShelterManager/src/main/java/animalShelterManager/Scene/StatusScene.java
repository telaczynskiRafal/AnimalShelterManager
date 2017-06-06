package animalShelterManager.Scene;

import animalShelterManager.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatusScene {
	public static void display() {
		Stage statusStage = new Stage();
		statusStage.initModality(Modality.APPLICATION_MODAL);
		statusStage.setTitle("Shelter status");
		statusStage.setMinHeight(200);
		statusStage.setMinWidth(200);
		statusStage.setResizable(false);

		String status = Main.status();

		Button okButton = new Button("OK");
		okButton.setMinWidth(80);
		okButton.setOnAction(e -> statusStage.close());

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.getChildren().add(okButton);
		hBox.setAlignment(Pos.CENTER);

		Label shelterStatusLabel = new Label(status);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(shelterStatusLabel);
		borderPane.setBottom(hBox);

		Scene scene = new Scene(borderPane, 300, 200);
		statusStage.setScene(scene);
		statusStage.showAndWait();
	}
}
