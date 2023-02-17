package com.kbs.templateortest.design.patterns.abst.factory.product;

public class WindowsButton implements Button {

    @Override
    public void print() {
        System.out.println("WindowsButton.print");
    }
}
