package service.impl;

import service.PrinterService;
import service.TextProvider;
import service.TextService;

import java.io.IOException;

import static utils.LoggerUtils.print;
import static utils.TextUtils.getMapChar;

public class TextServiceImpl implements TextService {

    private TextProvider textProvider;
    private PrinterService printerService;

    @Override
    public void count() {
        var text = getText();
        var map = getMapChar(text);
        printerService.printMapCount(map, text);
    }

    public TextServiceImpl(TextProvider textProvider,
                           PrinterService printerService) {
        this.textProvider = textProvider;
        this.printerService = printerService;
    }

    private String getText() {
        try {
            return textProvider.getContent();
        } catch (IOException e) {
            print("При получении текста произошла ошибка: ", e);
            throw new RuntimeException();
        }
    }
}
