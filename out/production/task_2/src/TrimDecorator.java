import java.awt.*;

public class TrimDecorator extends BaseAbstractDecorator{

    public TrimDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return text.trim();
    }


}
