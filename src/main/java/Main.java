import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        GeneratorUrl generatorUrl = new GeneratorUrl();
        ContentGetter contentGetter = new ContentGetter(generatorUrl);
        Counter counter = new Counter(contentGetter.getText());
        Printer printer = new Printer(counter);

        printer.print();
    }








}
