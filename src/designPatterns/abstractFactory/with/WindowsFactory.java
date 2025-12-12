package designPatterns.abstractFactory.with;

import designPatterns.abstractFactory.without.WindowCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Buttons createButton() {
        return new WindowButtons();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WindowCheckbox();
    }
}
