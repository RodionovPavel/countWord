package utils;

public class LoggerUtils {

    public static void print(String s, Object... args) {
        System.out.println(s.formatted(args));
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
