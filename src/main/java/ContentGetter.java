import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContentGetter {

    private String text;

    public ContentGetter(GeneratorUrl generatorUrl) throws IOException {

        URL address = new URL(generatorUrl.getText());
        HttpURLConnection connection = (HttpURLConnection) address.openConnection();

        connection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        text = in.readLine();

        in.close();
    }

    public String getText() {
        return text;
    }

}
