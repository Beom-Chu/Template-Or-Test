package com.kbs.templateortest.design.patterns.factory.method;

public class FactoryMethodApplication {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new WebDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.render();
    }
}