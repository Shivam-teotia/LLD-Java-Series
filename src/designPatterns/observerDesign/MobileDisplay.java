package designPatterns.observerDesign;

public class MobileDisplay implements Observer{
    @Override
    public void update() {
        System.out.println("Update mobile display screen");
    }
}
