package designPatterns.abstractFactory.with;

public class WindowButtons implements Buttons{
    @Override
    public void paint() {
        System.out.println("window button paint");
    }

    @Override
    public void onClick() {
        System.out.println("window button onclick");
    }
}
