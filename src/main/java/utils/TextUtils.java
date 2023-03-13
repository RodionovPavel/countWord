package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    public static Map<String, Integer> getMapChar(String text) {

        String clearString = text.toLowerCase().replaceAll("[^\\da-zA-Z]", "");

        String[] splittedString = clearString.split("");

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(splittedString).forEach(c -> {
            Integer count = map.get(c);
            map.put(c, (count == null) ? 1 : count + 1);
        });
        return map;
    }
}
