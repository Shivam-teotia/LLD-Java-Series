package designPatterns.abstractFactory.without;

import designPatterns.abstractFactory.with.CheckBox;

public class WindowCheckbox implements CheckBox {
    public void paint(){
        System.out.println("painting a window check box button");
    }
    public void onClick(){
        System.out.println("window checkbox button clicked");
    }
}
