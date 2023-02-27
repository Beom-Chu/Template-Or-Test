package com.kbs.templateortest.design.patterns.builder.concretbuilder;

import com.kbs.templateortest.design.patterns.builder.builder.SaladBuilder;
import com.kbs.templateortest.design.patterns.builder.product.Salad;

public class Chef implements SaladBuilder {
    private Salad salad;

    public Chef() {
        this.salad = new Salad("", "");
    }

    @Override
    public void setVegetables(String vegetables) {
        salad.setVegetables(vegetables);
    }

    @Override
    public void setDressing(String dressing) {
        salad.setDressing(dressing);
    }

    @Override
    public Salad getSalad() {
        return salad;
    }
}
