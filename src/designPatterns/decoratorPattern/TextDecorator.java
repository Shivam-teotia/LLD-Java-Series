package designPatterns.decoratorPattern;

public abstract class TextDecorator implements TextView {
    protected final TextView inner;

    protected TextDecorator(TextView inner) {
        this.inner = inner;
    }
}
