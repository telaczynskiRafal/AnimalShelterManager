package animalShelterManager;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RemoveAnimalScene {
	
	public static void display() {
		Button exitButton, removeButton;
		Label animalNameLabel, animalTypeLabel;
		TextField animalNameTextField;
		ChoiceBox<String> animalTypeChoiceBox;
		
		Stage removeAnimalStage = new Stage();
		removeAnimalStage.initModality(Modality.APPLICATION_MODAL);
		removeAnimalStage.setTitle("Remove animals");
		removeAnimalStage.setMinHeight(200);
		removeAnimalStage.setMinWidth(200);
		
		Group root = new Group();
		BorderPane borderPane = new BorderPane();
		
		Scene scene = new Scene(root, 300, 200);
		
		animalNameLabel = new Label("Animal name:");
		animalTypeLabel = new Label("Animal type:");
		
		animalNameTextField = new TextField();
		animalTypeChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Dog", "Cat"));
		
		exitButton = new Button("Exit");
		exitButton.setMinWidth(80);
		exitButton.setOnAction(e -> removeAnimalStage.close());
		removeButton = new Button("Remove animals");
		removeButton.setMinWidth(80);
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(20,20,20,20));
		hBox.getChildren().addAll(exitButton, removeButton);
		hBox.setSpacing(20);
		hBox.setAlignment(Pos.CENTER);
		
		VBox byNameVBox = new VBox();
		byNameVBox.setPadding(new Insets(20,20,20,20));
		byNameVBox.getChildren().addAll(animalNameLabel, animalNameTextField);
		byNameVBox.setSpacing(20);
		byNameVBox.setAlignment(Pos.CENTER);
		
		VBox byTypeVBox = new VBox();
		byTypeVBox.setPadding(new Insets(20,20,20,20));
		byTypeVBox.getChildren().addAll(animalTypeLabel, animalTypeChoiceBox);
		byTypeVBox.setSpacing(20);
		byTypeVBox.setAlignment(Pos.CENTER);
		
		TabPane tabsPane = new TabPane();
		Tab byNameTab = new Tab("By name");
		byNameTab.setContent(byNameVBox);
		Tab byTypeTab = new Tab("By type");
		byTypeTab.setContent(byTypeVBox);
		
		
		tabsPane.getTabs().addAll(byNameTab, byTypeTab);
		
		borderPane.setTop(tabsPane);
		borderPane.setBottom(hBox);
		
		root.getChildren().add(borderPane);
		
		
		
		removeAnimalStage.setScene(scene);
		removeAnimalStage.show();
	}
}
