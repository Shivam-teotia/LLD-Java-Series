package designPatterns.abstractFactory.with;


public class Application {
    private final Buttons button;
    private final CheckBox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.paint();
        checkbox.paint();
    }
}