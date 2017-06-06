package animalShelterManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import animalShelterManager.Domain.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Reader {

	public static void readFromFile(Stage stage) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt"));
		fc.setTitle("Open file");
		File file = fc.showOpenDialog(stage);
		if (file != null) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream input = new ObjectInputStream(fis);
				@SuppressWarnings("unchecked")
				ObservableList<Animal> animals = FXCollections
						.observableArrayList((ArrayList<Animal>) input.readObject());
				Main.animals.addAll(animals);
				Main.animalsInShelterTableView.setItems(Main.animals);
				input.close();
			} catch (FileNotFoundException e) {
				Alert alert = new Alert(AlertType.INFORMATION, "File not found!", ButtonType.OK);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.showAndWait();
			} catch (ClassNotFoundException e) {
				Alert alert = new Alert(AlertType.INFORMATION, "Corrupted file!", ButtonType.OK);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.showAndWait();
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.INFORMATION, "Something went wrong! Check logs.", ButtonType.OK);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.showAndWait();
				e.printStackTrace();
			}
		}
	}
}
