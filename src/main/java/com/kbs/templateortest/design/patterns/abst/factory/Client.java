package com.kbs.templateortest.design.patterns.abst.factory;

import com.kbs.templateortest.design.patterns.abst.factory.product.Button;
import com.kbs.templateortest.design.patterns.abst.factory.product.CheckBox;

public class Client {
    private Button button;
    private CheckBox checkBox;

    public Client(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void print() {
        button.print();
        checkBox.print();
    }
}
