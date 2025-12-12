package designPatterns.abstractFactory.without;

public class Main {
    public static void main(String[] args){
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            WindowsButton button = new WindowsButton();
            WindowCheckbox checkbox = new WindowCheckbox();
            button.paint();
            checkbox.paint();
        } else if (os.contains("Mac")) {

        }
    }
}
