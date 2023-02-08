package com.kbs.templateortest.design.patterns.factory.method;

public class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}
