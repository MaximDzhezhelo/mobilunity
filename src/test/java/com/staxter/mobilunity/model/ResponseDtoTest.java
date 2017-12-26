package com.staxter.mobilunity.model;

import com.staxter.mobilunity.ApplicationTest;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ResponseDtoTest implements ApplicationTest {

    @Test
    public void readJsonFromFile() throws IOException {
        assertTrue(Files.exists(Paths.get(RESPONSE_JSON)));

        byte[] bytes = Files.readAllBytes(Paths.get(RESPONSE_JSON));

        final ResponseDto responseDto = objectMapper.readValue(bytes, ResponseDto.class);
        assertNotNull(responseDto);
        assertEquals(FIRST_NAME, responseDto.getFirstName());
        assertEquals(LAST_NAME, responseDto.getLastName());
        assertEquals(USER_NAME, responseDto.getUserName());
        assertEquals(ID_RESPONSE, responseDto.getId());
    }

}