package com.kbs.templateortest.design.patterns.abst.factory.product;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void print() {
        System.out.println("WindowsCheckBox.print");
    }
}
