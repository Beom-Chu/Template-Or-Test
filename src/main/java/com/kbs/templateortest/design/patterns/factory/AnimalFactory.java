package com.kbs.templateortest.design.patterns.factory;

import java.util.Objects;

public class AnimalFactory {

    public Animal createAnimal(AnimalType animalType) throws Exception {
        if(Objects.equals(animalType, AnimalType.CAT)) {
            return new Cat();
        } else if(Objects.equals(animalType, AnimalType.DOG)) {
            return new Dog();
        } else {
            throw new Exception("No AnimalType!!");
        }
    }
}
