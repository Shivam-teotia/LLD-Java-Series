package designPatterns.abstractFactory.with;

public class MacOSCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("mac os checkbox paint");
    }

    @Override
    public void onClick() {
        System.out.println("mac os checkbox on click");
    }
}
