package designPatterns.abstractFactory.with;

public interface GUIFactory {
    Buttons createButton();
    CheckBox createCheckbox();
}
