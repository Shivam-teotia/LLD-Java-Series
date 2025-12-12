package designPatterns.decoratorPattern;

public class ItalicDecorator extends TextDecorator{
    protected ItalicDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        System.out.print("<i>");
        inner.render();
        System.out.print("</i>");
    }
}
