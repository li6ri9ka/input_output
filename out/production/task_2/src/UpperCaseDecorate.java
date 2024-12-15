public class UpperCaseDecorate extends BaseAbstractDecorator{
    public UpperCaseDecorate(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String input) {
        return input.toUpperCase();
    }


}
