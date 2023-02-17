package com.kbs.templateortest.design.patterns.abst.factory.product;

public class MacOSButton implements Button {

    @Override
    public void print() {
        System.out.println("MacOSButton.print");
    }
}
