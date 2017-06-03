package animalShelterManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Animal {
	private final StringProperty name;
	private final StringProperty type;

	public Animal(String name, String type) {
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String animalName) {
		name.set(animalName);
	}

	public String getType() {
		return type.get();
	}

	public void setType(String animalType) {
		type.set(animalType);
	}

	@Override
	public String toString() {
		return type.get().toLowerCase() + " named " + name;
	}

}
