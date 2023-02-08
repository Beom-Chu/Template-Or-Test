package com.kbs.templateortest.design.patterns.factory.method;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("WindowsButton.render");
    }

    @Override
    public void onClick() {
        System.out.println("WindowsButton.onClick");
    }
}
