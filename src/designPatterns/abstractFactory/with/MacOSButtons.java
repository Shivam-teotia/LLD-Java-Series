package designPatterns.abstractFactory.with;

public class MacOSButtons implements Buttons{
    @Override
    public void paint() {
        System.out.println("mac os button paint");
    }

    @Override
    public void onClick() {
        System.out.println("mac os button on click");
    }
}
