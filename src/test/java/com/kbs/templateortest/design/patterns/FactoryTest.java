package com.kbs.templateortest.design.patterns;

import com.kbs.templateortest.design.patterns.factory.Animal;
import com.kbs.templateortest.design.patterns.factory.AnimalFactory;
import com.kbs.templateortest.design.patterns.factory.AnimalType;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void testFactory() throws Exception {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal cat = animalFactory.createAnimal(AnimalType.CAT);
        Animal dog = animalFactory.createAnimal(AnimalType.DOG);

        cat.speak();
        dog.speak();

        System.out.println("[[[cat.getAnimalType() = " + cat.getAnimalType());
        System.out.println("[[[dog.getAnimalType() = " + dog.getAnimalType());
    }
}
