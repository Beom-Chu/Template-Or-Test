package com.kbs.templateortest.design.patterns.abst.factory;

public class Demo {
    private static Client configureApplication() {

        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if(osName.contains("mac")) {
            factory = new MacOsFactory();
        } else {
            factory = new WindowsFactory();
        }

        return new Client(factory);
    }

    public static void main(String[] args) {
        Client client = configureApplication();
        client.print();
    }
}
