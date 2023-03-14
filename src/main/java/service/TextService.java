package service;

import service.impl.MyCustomException;

public interface TextService {

    void count() throws MyCustomException;

}
