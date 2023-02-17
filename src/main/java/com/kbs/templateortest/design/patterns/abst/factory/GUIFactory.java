package com.kbs.templateortest.design.patterns.abst.factory;

import com.kbs.templateortest.design.patterns.abst.factory.product.Button;
import com.kbs.templateortest.design.patterns.abst.factory.product.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
