package com.staxter.mobilunity.controller.integration;

import com.staxter.mobilunity.ApplicationTest;
import com.staxter.mobilunity.controller.UserRegistrationController;
import com.staxter.mobilunity.service.RegistrationService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.staxter.mobilunity.controller.GlobalControllerExceptionHandler.ERROR_RESPONSE;
import static com.staxter.mobilunity.controller.UserRegistrationController.URL_REGISTRATION;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRegistrationControllerIntegrationTest implements ApplicationTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void testRequest_A() throws Exception {
        MvcResult mvcResult = mvc.perform(post(URL_REGISTRATION)
                .accept(MediaType.APPLICATION_JSON).content(getRequest())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertTrue(content.contains(FIRST_NAME));
        assertTrue(content.contains(LAST_NAME));
        assertTrue(content.contains(USER_NAME));
    }

    @Test
    public void testRequest_B() throws Exception {
       mvc.perform(post(URL_REGISTRATION)
                .accept(MediaType.APPLICATION_JSON).content(getRequest())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().string(ERROR_RESPONSE));

    }

}