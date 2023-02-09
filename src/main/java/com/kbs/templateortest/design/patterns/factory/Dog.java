package com.kbs.templateortest.design.patterns.factory;

public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("멍멍!!");
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DOG;
    }
}
