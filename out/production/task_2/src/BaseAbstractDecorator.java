abstract class BaseAbstractDecorator implements  TextProcessor{
    protected TextProcessor processor;
    public BaseAbstractDecorator(TextProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String text) {
        return processor.process(text);
    }
}
