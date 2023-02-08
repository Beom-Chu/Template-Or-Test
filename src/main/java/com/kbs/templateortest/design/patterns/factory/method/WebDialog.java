package com.kbs.templateortest.design.patterns.factory.method;

public class WebDialog extends Dialog {
    @Override
    Button createButton() {
        return new HTMLButton();
    }
}
