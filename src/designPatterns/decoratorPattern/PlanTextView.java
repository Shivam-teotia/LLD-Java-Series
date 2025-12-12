package designPatterns.decoratorPattern;

public class PlanTextView implements TextView{
    private String text;
    public PlanTextView(String text){
        this.text = text;
    }
    @Override
    public void render() {
        System.out.println("render from plain text view "+text);
    }
}
