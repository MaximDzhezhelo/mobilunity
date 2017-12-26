package com.staxter.mobilunity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface ApplicationTest {

    String REQUEST_JSON = "src/test/resources/fileExample/Request.json";
    String RESPONSE_JSON = "src/test/resources/fileExample/Response.json";

    String FIRST_NAME = "Some first name";
    String LAST_NAME = "The last name";
    String USER_NAME = "The user name";
    String PASSWORD_REQUEST = "The password in plain text";

    String ID_RESPONSE = "Id generated by the back-end";

    ObjectMapper objectMapper = new ObjectMapper();

    default byte[] getRequest() throws IOException { return Files.readAllBytes(Paths.get(REQUEST_JSON)); }
}
