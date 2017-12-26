package com.staxter.mobilunity.controller;

import com.staxter.mobilunity.ApplicationTest;
import com.staxter.mobilunity.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.staxter.mobilunity.controller.UserRegistrationController.URL_REGISTRATION;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest implements ApplicationTest{

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RegistrationService registrationService;

    @Test
    public void testRequest() throws Exception {
        mvc.perform(post(URL_REGISTRATION)
                .accept(MediaType.APPLICATION_JSON).content(getRequest())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}