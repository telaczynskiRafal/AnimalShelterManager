package animalShelterManager.Domain;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Animal implements Serializable {
	private String name;
	private String type;
	private transient StringProperty nameProperty;
	private transient StringProperty typeProperty;

	public Animal() {
	}

	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
		this.nameProperty = new SimpleStringProperty(name);
		this.typeProperty = new SimpleStringProperty(type);
	}

	public String getNameProperty() {
		return nameProperty.get();
	}

	public void setNameProperty(String animalName) {
		nameProperty.set(animalName);
	}

	public String getTypeProperty() {
		return typeProperty.get();
	}

	public void setTypeProperty(String animalType) {
		typeProperty.set(animalType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type.toLowerCase() + " named " + name;
	}

}
