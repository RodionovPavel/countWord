import properties.TextProperties;
import service.TextProvider;
import service.TextService;
import service.impl.NumbersApiTextProvider;
import service.impl.PrinterServiceImpl;
import service.impl.TextServiceImpl;

public class Main {
    public static void main(String[] args) {
        TextProvider textProvider = new NumbersApiTextProvider(new TextProperties());
        TextService textService = new TextServiceImpl(textProvider, new PrinterServiceImpl());
        textService.count();
    }
}
