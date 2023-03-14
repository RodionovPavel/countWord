package service.impl;

import service.PrinterService;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static utils.LoggerUtils.print;

public class PrinterServiceImpl implements PrinterService {
    private double averageValue;

    @Override
    public void printMapCount(Map<String, Integer> map, String text) {
        var treeMap = new TreeMap<>(map);
        print(text);
        print("\nЧастоты:");
        printMap(treeMap);
        printAverageValue(treeMap, text);
        printSymbols(treeMap);
    }

    private void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            print("%s - %s %s", entry.getKey(), entry.getValue(), fixRightEnd(entry.getValue()));
        }
    }

    private void printAverageValue(Map<String, Integer> map, String text) {
        averageValue = (double) text.length() / map.size();
        print("\nСреднее значение частоты " + text.length() + "/" + map.size() + " = " + averageValue);
    }

    private void printSymbols(Map<String, Integer> map) {
        Set<String> keys = new HashSet<>();
        int averageValueToInt = (int) Math.round(averageValue);

        // фильтруем только те ключи, чья частота близка к среднему значению
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(averageValueToInt)) {
                keys.add(entry.getKey());
            }
        }

        if (!keys.isEmpty()) {
            System.out.print("Символы, которые соответствуют условию наиболее близкого значения частоты к среднему значению: ");
//            Iterator iterator = keys.iterator();
//            while (iterator.hasNext()) {
//                String a = (String) iterator.next();
//                byte[] bytes = a.getBytes(StandardCharsets.UTF_8);
//                System.out.print(a + "(" + bytes[0] + ")");
//                if (iterator.hasNext()) {
//                    System.out.print(", ");
//                } else {
//                    System.out.print(".");
//                }
//            }
            String lettersWithSymbols = keys.stream()
                    .map(s -> {
                        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
                        return s + "(" + bytes[0] + ")";
                    })
                    .collect(Collectors.joining(", "));
            System.out.println(lettersWithSymbols.concat("."));

        } else {
            System.out.println("Увы, но нет символов, которые соответствуют условию наиболее близкого значения частоты к среднему значению.");
        }
    }

    private void printText(String text) {
        print(text);
    }

    private String fixRightEnd(int number) {

        // для чисел более 10 и менее 20
        int result = number % 100;
        if (result >= 10 && result <= 20) {
            return "раз";
        }

        // для всех остальных вычисляем последнее число
        result = number % 10;
        return switch (result) {
            case 2, 3, 4 -> "раза";
            default -> "раз";
        };
    }
}
