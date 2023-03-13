package properties;

public class TextProperties {

    private String url = "http://numbersapi.com/%s/trivia";
    private int minNum = 0;
    private int maxNum = 1000;

    public String getUrl() {
        return url;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }
}
