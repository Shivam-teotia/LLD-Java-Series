package designPatterns.abstractFactory.with;

public class WindowButtonCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("window button checkbox paint");
    }

    @Override
    public void onClick() {
        System.out.println("window button checkbox click");
    }
}
