package designPatterns.decoratorPattern;

public class BoldDecorator extends TextDecorator{
    protected BoldDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        System.out.println("<b>");
        inner.render();
        System.out.println("</b>");
    }
}
