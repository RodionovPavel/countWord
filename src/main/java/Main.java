import properties.TextProperties;
import service.TextProvider;
import service.TextService;
import service.impl.MyCustomException;
import service.impl.NumbersApiTextProvider;
import service.impl.PrinterServiceImpl;
import service.impl.TextServiceImpl;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws MyCustomException {
        TextProvider textProvider = new NumbersApiTextProvider(new TextProperties());
        TextService textService = new TextServiceImpl(textProvider, new PrinterServiceImpl());
        textService.count();
    }
}
