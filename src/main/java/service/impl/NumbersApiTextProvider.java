package service.impl;

import properties.TextProperties;
import service.TextProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NumbersApiTextProvider implements TextProvider {

    private TextProperties textProperties;

    @Override
    public String getContent() throws IOException {
        URL address = new URL(textProperties.getUrl().formatted(getRandom()));
        HttpURLConnection connection = (HttpURLConnection) address.openConnection();

        connection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String text = in.readLine();

        in.close();
        return text;
    }

    private int getRandom() {
        return (int) (Math.random() * (textProperties.getMaxNum() + 1));
    }

    public NumbersApiTextProvider(TextProperties textProperties) {
        this.textProperties = textProperties;
    }
}
