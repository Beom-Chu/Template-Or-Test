package com.kbs.templateortest.design.patterns.builder.product;

public class Salad {
    private String vegetables;
    private String dressing;

    public Salad(String vegetables, String dressing) {
        this.vegetables = vegetables;
        this.dressing = dressing;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public String toString() {
        return "Salad [vegetables=" + vegetables + ", dressing=" + dressing + "]";
    }
}
