package com.staxter.mobilunity.model;

import com.staxter.mobilunity.ApplicationTest;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class RequestDtoTest implements ApplicationTest{

    @Test
    public void readJsonFromFile() throws IOException {
        assertTrue(Files.exists(Paths.get(REQUEST_JSON)));

        byte[] bytes = Files.readAllBytes(Paths.get(REQUEST_JSON));

        final RequestDto requestDto = objectMapper.readValue(bytes, RequestDto.class);
        assertNotNull(requestDto);
        assertEquals(FIRST_NAME, requestDto.getFirstName());
        assertEquals(LAST_NAME, requestDto.getLastName());
        assertEquals(USER_NAME, requestDto.getUserName());
        assertEquals(PASSWORD_REQUEST, requestDto.getPassword());
    }

}