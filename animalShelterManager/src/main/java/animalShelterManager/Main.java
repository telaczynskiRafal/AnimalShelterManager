package animalShelterManager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	static TextArea animalsInShelterTextArea;
	static TableView<Animal> animalsInShelterTableView;
	static ObservableList<Animal> animals;
	Button addAnimalButton, removeAnimalButton, statusButton, exitButton;
	Label animalsInShelterLabel;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		animals = FXCollections.observableArrayList();
		primaryStage.setTitle("Animal Shelter Manager");

		addAnimalButton = new Button("Add an animal");
		addAnimalButton.setMaxWidth(Double.MAX_VALUE);
		removeAnimalButton = new Button("Remove animals");
		removeAnimalButton.setMaxWidth(Double.MAX_VALUE);
		statusButton = new Button("Shelter status");
		statusButton.setMaxWidth(Double.MAX_VALUE);
		exitButton = new Button("Exit");
		exitButton.setMaxWidth(Double.MAX_VALUE);

		addAnimalButton.setOnAction(e -> AddAnimalScene.display());
		removeAnimalButton.setOnAction(e -> RemoveAnimalScene.display());
		exitButton.setOnAction(e -> primaryStage.close());

		VBox modifyButtonsBox = new VBox();
		modifyButtonsBox.setPadding(new Insets(20, 20, 20, 20));
		modifyButtonsBox.setSpacing(30);
		modifyButtonsBox.getChildren().addAll(addAnimalButton, removeAnimalButton, statusButton, exitButton);

		animalsInShelterLabel = new Label("Animals currently in shelter:");
		animalsInShelterLabel.setPadding(new Insets(0, 0, 5, 0));
		animalsInShelterTableView = new TableView<>();
		animalsInShelterTableView.setEditable(false);
		TableColumn<Animal, String> animalTypeColumn = new TableColumn<>("Animal's type");
		animalTypeColumn.prefWidthProperty().set(125);
		animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		TableColumn<Animal, String> animalNameColumn = new TableColumn<>("Animal's name");
		animalNameColumn.prefWidthProperty().set(125);
		animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		animalsInShelterTableView.getColumns().addAll(animalTypeColumn, animalNameColumn);

		BorderPane border = new BorderPane();
		border.setTop(animalsInShelterLabel);
		border.setPadding(new Insets(20, 20, 20, 20));
		border.setLeft(animalsInShelterTableView);
		border.setRight(modifyButtonsBox);

		Scene scene = new Scene(border, 430, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
