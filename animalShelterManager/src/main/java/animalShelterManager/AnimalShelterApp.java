package animalShelterManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalShelterApp {
	private static Shelter shelter = new Shelter("Shelter", 5);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Your action (ADD/REMOVE/STATUS/EXIT): ");
			String action = scanner.next();
			if (action.equalsIgnoreCase("ADD")) {
				if (shelter.getAllAnimals() != null && shelter.getCapacity() == shelter.getAllAnimals().size()) {
					System.out.println("Shelter is full!");
				} else {
					System.out.print("Animal type (CAT/DOG): ");
					String type = scanner.next();
					System.out.print("Animal name: ");
					String name = scanner.next();
					Animal animal = new Animal(name, type);
					shelter.addAnimal(animal);
				}
			} else if (action.equalsIgnoreCase("REMOVE")) {
				System.out.print("Animal to remove name: ");
				String name = scanner.next();
				List<Animal> animals = shelter.getAllAnimals();
				List<Animal> animalsToRemove = new ArrayList<>();
				int numberOfAnimalsToRemove = 0;
				for (Animal animal : animals) {
					if (animal.getName().equals(name)) {
						animalsToRemove.add(animal);
						numberOfAnimalsToRemove++;
					}
				}
				animals.removeAll(animalsToRemove);
				System.out.println(numberOfAnimalsToRemove + " animals removed!");
			} else if (action.equalsIgnoreCase("STATUS")) {
				status();
			} else if (action.equalsIgnoreCase("EXIT")) {
				return;
			} else {
				System.out.println("Unrecognized command! Try again!");
			}
		}

	}

	public static void status() {
		if (shelter.getAllAnimals().size() == 0) {
			System.out.println("Shelter is empty!");
		} else {
			List<Animal> animals = shelter.getAllAnimals();
			System.out.println("Animals currently in shelter: " + animals.toString());
			System.out.println(animals.size() < shelter.getCapacity() ? "There is some more place left!"
					: animals.size() == shelter.getCapacity() ? "Shelter is full!" : "Shelter is overloaded!");
		}
	}
}
