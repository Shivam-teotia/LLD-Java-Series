package designPatterns.observerDesign;

public class LEDDisplay implements Observer{
    @Override
    public void update() {
        System.out.println("update led display screen");
    }
}
