package com.crynner;

import java.util.ArrayList;
import java.util.List;

class Animal {
	
	public Animal(String species) {
	}

	public void assignTo(Zookeeper zookeeper) {
	}

	public boolean hasZookeeper() {
		return false;
	}

	public Zookeeper getZookeeper() {
		return null;
	}

	@Override
	public String toString() {
		return "";
	}
}

class Zookeeper {
	
	public Zookeeper(String name) {
	}

	public void takeCareOf(Animal animal) {
	}

	public List<Animal> getAssignedAnimals() {
		return null;
	}

	public boolean caresFor(Animal animal) {
		return false;
	}

	@Override
	public String toString() {
		return "";
	}
}

class ZooManager {

	public void addZookeeper(Zookeeper zookeeper) {
	}

	public void addAnimal(Animal animal) {
	}

	public void assignAnimalToZookeeper(Animal animal, Zookeeper zookeeper) {
	}

	public List<Animal> getUnassignedAnimals() {
		return null;
	}

	public List<Zookeeper> getIdleZookeepers() {
		return null;
	}
}
