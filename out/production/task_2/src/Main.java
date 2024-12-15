public class Main {
    public static void main(String[] args) {
        String proccesString = "   hello wo rl d    ";
        TextProcessor textProcessor = new SimpleTextProcessor();
        TextProcessor upperCaseProcessor = new UpperCaseDecorate(textProcessor);
        TextProcessor ReplaceProcessor = new ReplaceDecorator(upperCaseProcessor);
        System.out.println(ReplaceProcessor.process(upperCaseProcessor.process(proccesString)));


    }
}
