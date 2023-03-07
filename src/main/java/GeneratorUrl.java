public class GeneratorUrl {
    private int max = 1000;
    private int randomNumber;

    private String text;

    public GeneratorUrl() {
        //рандомное число от 0 до 1000 включительно
        randomNumber = (int) (Math.random() * ++max);
    }

    public String randomUrl(int randomNumber) {
        return text = "http://numbersapi.com/" + randomNumber + "/trivia";
    }

    public String getText() {
        return text;
    }

    public int getMax() {
        return max;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
