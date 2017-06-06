package animalShelterManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Writer {
	public static void writeToFile(Stage stage) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt"));
		fc.setTitle("Save to file");
		File file = fc.showSaveDialog(stage);
		if (file != null) {
			try {
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
				output.writeObject(new ArrayList<>(Main.animals));
				output.flush();
				output.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
