package com.kbs.templateortest.design.patterns.abst.factory;

import com.kbs.templateortest.design.patterns.abst.factory.product.Button;
import com.kbs.templateortest.design.patterns.abst.factory.product.CheckBox;
import com.kbs.templateortest.design.patterns.abst.factory.product.WindowsButton;
import com.kbs.templateortest.design.patterns.abst.factory.product.WindowsCheckBox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
