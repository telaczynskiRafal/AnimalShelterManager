package animalShelterManager;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAnimalScene {
	static Animal animal;

	public static void display() {
		Button addAnimalButton, exitButton;
		Label animalNameLabel, animalTypeLabel;
		TextField animalNameTextField;
		ChoiceBox<String> animalTypChoiceBox;
		VBox vBox;
		HBox hBox;
		Stage addAnimalStage = new Stage();

		addAnimalStage.initModality(Modality.APPLICATION_MODAL);
		addAnimalStage.setTitle("Add an animal");
		addAnimalStage.setMinHeight(200);
		addAnimalStage.setMinWidth(200);

		addAnimalButton = new Button("Add an Animal");
		addAnimalButton.setMinWidth(80);
		exitButton = new Button("Exit");
		exitButton.setMinWidth(80);
		exitButton.setOnAction(e -> addAnimalStage.close());

		animalNameLabel = new Label("Animal's name:");
		animalTypeLabel = new Label("Animal's type:");

		animalNameTextField = new TextField();

		animalTypChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Dog", "Cat"));

		vBox = new VBox();
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.setSpacing(5);
		vBox.getChildren().addAll(animalNameLabel, animalNameTextField, animalTypeLabel, animalTypChoiceBox);

		hBox = new HBox();
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setSpacing(30);
		hBox.getChildren().addAll(exitButton, addAnimalButton);
		hBox.setAlignment(Pos.CENTER);

		BorderPane border = new BorderPane();
		border.setTop(vBox);
		border.setBottom(hBox);

		Scene scene = new Scene(border, 300, 200);
		addAnimalStage.setScene(scene);

		

		addAnimalButton.setOnAction(e -> {
			String animalName = animalNameTextField.getText();
			String animalType = animalTypChoiceBox.getValue().toString();
			animal = new Animal(animalName, animalType.toLowerCase());
			Main.animals.add(animal);
			Main.animalsInShelterTableView.setItems(Main.animals);
			addAnimalStage.close();
		});

		addAnimalStage.showAndWait();

	}
}
