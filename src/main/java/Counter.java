import java.util.HashMap;
import java.util.Map;

public class Counter {

    private String text;
    private Map<String, Integer> map;

    public Counter(String text) {
        this.text = text;

        // удаляем всё кроме букв и цифр
        String clearString = text.toLowerCase().replaceAll("[^\\da-zA-Z]", "");

        String[] splittedString = clearString.split("");

        map = new HashMap<>();
        for (String temp : splittedString) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public String getText() {
        return text;
    }
}
