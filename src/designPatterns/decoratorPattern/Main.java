package designPatterns.decoratorPattern;

public class Main {
    public static void main(String[] args){
        TextView textView = new PlanTextView("Hello world");
        textView.render();

        TextView boldTextView = new BoldDecorator(textView);
        boldTextView.render();

        TextView italicTextView =  new ItalicDecorator(boldTextView);
        italicTextView.render();
    }
}
