package com.kbs.templateortest.design.patterns.builder.director;

import com.kbs.templateortest.design.patterns.builder.builder.SaladBuilder;
import com.kbs.templateortest.design.patterns.builder.product.Salad;

public class SaladMaker {
    private SaladBuilder builder;

    public SaladMaker(SaladBuilder builder) {
        this.builder = builder;
    }

    public Salad makeSalad() {
        builder.setVegetables("Lettuce, tomatoes, onions");
        builder.setDressing("Vinaigrette");
        return builder.getSalad();
    }
}
