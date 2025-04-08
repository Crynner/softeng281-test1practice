package com.crynner;

import java.util.ArrayList;
import java.util.List;

class Animal {
	private String species;
	Zookeeper assigned = null;
	
	public Animal(String species) {
		this.species = species;
	}

	public void assignTo(Zookeeper zookeeper) {
		if (zookeeper == null) {
			return;
		}
		if (assigned != null) {
			assigned.unassignAnimal(this); // also resets
		}
		assigned = zookeeper;
		zookeeper.takeCareOf(this);
	}

	public void unassign() {
		assigned = null;
	}

	public boolean hasZookeeper() {
		return assigned != null;
	}

	public Zookeeper getZookeeper() {
		return assigned;
	}

	@Override
	public String toString() {
		return species;
	}
}

class Zookeeper {
	private String name;
	private List<Animal> assigned = new ArrayList<>();
	
	public Zookeeper(String name) {
		this.name = name;
	}

	public void takeCareOf(Animal animal) {
		assigned.add(animal);
	}

	public void unassignAnimal(Animal animal) {
		assigned.remove(animal);
		if (animal.getZookeeper() == this) {
			animal.unassign();
		}
	}

	public List<Animal> getAssignedAnimals() {
		return assigned;
	}

	public boolean caresFor(Animal animal) {
		return assigned.contains(animal);
	}

	@Override
	public String toString() {
		return String.format("%s (%d animals)", name, assigned.size());
	}
}

class ZooManager {
	List<Zookeeper> keepers = new ArrayList<>();
	List<Zookeeper> idlers = new ArrayList<>();
	List<Animal> animals = new ArrayList<>();
	List<Animal> unassigned = new ArrayList<>();

	public void addZookeeper(Zookeeper zookeeper) {
		keepers.add(zookeeper);
		idlers.add(zookeeper);
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
		unassigned.add(animal);
	}

	public void assignAnimalToZookeeper(Animal animal, Zookeeper zookeeper) {
		if (idlers.contains(zookeeper)) {
			idlers.remove(zookeeper);
		}
		zookeeper.takeCareOf(animal);
		animal.assignTo(zookeeper);
	}

	public List<Animal> getUnassignedAnimals() {
		return unassigned;
	}

	public List<Zookeeper> getIdleZookeepers() {
		return idlers;
	}
}
