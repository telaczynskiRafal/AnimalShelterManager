package animalShelterManager;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
	private String name;
	private int capacity;
	private List<Animal> animals;

	public Shelter() {
	}

	public Shelter(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.animals = new ArrayList<Animal>();
	}

	public List<Animal> getAllAnimals() {
			return animals;
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public void removeAnimal(Animal animal) {
		animals.remove(animal);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

}
