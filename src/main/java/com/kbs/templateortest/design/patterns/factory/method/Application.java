package com.kbs.templateortest.design.patterns.factory.method;

import java.util.Objects;

public class Application {

    private Dialog dialog;

    private void initialize(String os) throws Exception {

        if(Objects.equals(os, "Windows")) {
            dialog = new WindowsDialog();
        } else if (Objects.equals(os, "Web")) {
            dialog = new WebDialog();
        } else {
            throw new Exception("ERROR!!");
        }
    }

    public void main(String os) throws Exception {
        this.initialize(os);
        dialog.render();
    }
}
