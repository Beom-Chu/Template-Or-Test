package com.kbs.templateortest.design.patterns.factory;

public class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("야옹!!");
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.CAT;
    }
}
