public class ReplaceDecorator extends BaseAbstractDecorator{

    public ReplaceDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return text.replace(' ','_');
    }


}

