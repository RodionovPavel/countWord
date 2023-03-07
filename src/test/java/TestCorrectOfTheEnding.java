import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка правильности окончания в зависимости от цифры")
public class TestCorrectOfTheEnding {
    Printer printer = new Printer();

    @Test
    void testCorrectOfTheEnding() {assertEquals("раз", printer.fixRightEnd(12));}
}
