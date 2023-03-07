import java.nio.charset.StandardCharsets;
import java.util.*;

public class Printer implements PrinterInterface {

    private double averageValue;
    private Map<String, Integer> treeMap;
    Map<String, Integer> map;
    String text;

    public Printer() {
    }

    public Printer(Counter counter) {
        map = counter.getMap();
        text = counter.getText();
    }

    @Override
    public void print() throws NullPointerException {
        printText();
        printCount();
        printSymbols();
    }

    public void printText() {
        System.out.println(text);
    }

    public void printCount() {
        treeMap = new TreeMap<>(map);
        System.out.println("\nЧастоты:");
        printMap(treeMap);
        averageValue = (double) text.length() / treeMap.size();
        System.out.println("\nСреднее значение частоты " + text.length() + "/" + treeMap.size() + " = " + averageValue);
    }

    public void printSymbols() {
        Set<String> keys = new HashSet<>();
        int averageValueToInt = (int) Math.round(averageValue);

        // фильтруем только те ключи, чья частота близка к среднему значению
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue().equals(averageValueToInt)) {
                keys.add(entry.getKey());
            }
        }

        if (!keys.isEmpty()) {
            System.out.print("Символы, которые соответствуют условию наиболее близкого значения частоты к среднему значению: ");
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                String a = (String) iterator.next();
                byte[] bytes = a.getBytes(StandardCharsets.UTF_8);
                System.out.print(a + "(" + bytes[0] + ")");
                if (iterator.hasNext()) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
            }
        } else {
            System.out.println("Увы, но нет символов, которые соответствуют условию наиболее близкого значения частоты к среднему значению.");
        }
    }

    public void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " " + fixRightEnd(entry.getValue()));
        }
    }

    public String fixRightEnd(int n) {

        // для чисел более 10 и менее 20
        int result = n % 100;
        if (result >= 10 && result <= 20) {
            return "раз";
        }

        // для всех остальных вычисляем последнее число
        result = n % 10;
        switch (result) {
            case 2:
            case 3:
            case 4:
                return "раза";
            default:
                return "раз";
        }
    }

    public double getAverageValue() {
        return averageValue;
    }

    public Map<String, Integer> getTreeMap() {
        return treeMap;
    }
}
