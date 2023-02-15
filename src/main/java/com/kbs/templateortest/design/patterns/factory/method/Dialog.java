package com.kbs.templateortest.design.patterns.factory.method;

public abstract class Dialog {
    abstract Button createButton();

    public void render() {
        Button button = createButton();
        button.render();
    }
}
