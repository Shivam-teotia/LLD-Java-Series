package designPatterns.abstractFactory.with;

public class MacOSFactory implements GUIFactory{
    @Override
    public Buttons createButton() {
        return new MacOSButtons();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacOSCheckBox();
    }
}
