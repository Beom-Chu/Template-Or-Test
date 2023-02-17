package com.kbs.templateortest.design.patterns.abst.factory;

import com.kbs.templateortest.design.patterns.abst.factory.product.Button;
import com.kbs.templateortest.design.patterns.abst.factory.product.CheckBox;
import com.kbs.templateortest.design.patterns.abst.factory.product.MacOSButton;
import com.kbs.templateortest.design.patterns.abst.factory.product.MacOSCheckBox;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
