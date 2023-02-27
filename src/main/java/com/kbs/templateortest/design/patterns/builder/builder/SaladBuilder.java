package com.kbs.templateortest.design.patterns.builder.builder;

import com.kbs.templateortest.design.patterns.builder.product.Salad;

public interface SaladBuilder {
    void setVegetables(String vegetables);
    void setDressing(String dressing);
    Salad getSalad();
}
