import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка создания URL")
public class TestGenerateUrl {
    private static int randomNumber = 1000;
    GeneratorUrl generatorUrl = new GeneratorUrl();

    @Test
    void testUrl() {assertEquals("http://numbersapi.com/1000/trivia", generatorUrl.randomUrl(randomNumber));}
}
