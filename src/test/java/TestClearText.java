import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка на очистку текста от символов и пробелов")
public class TestClearText {
        Counter counter = new Counter(" /.a%");

        @Test
        void testCorrectOfTheEnding() {assertEquals(1, counter.getMap().size());}
}
