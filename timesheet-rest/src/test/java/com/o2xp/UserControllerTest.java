package com.o2xp;

import com.o2xp.controller.UserController;
import com.o2xp.model.UserProfile;
import com.o2xp.service.UserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserProfileService userProfileService;

    @Test
    public void mustFindUserByUsernameAndPassword() throws Exception {
        UserProfile user = new UserProfile();

        user.setFirstName("Mohamed");
        user.setLastName("Toure");
        user.setUsername("mtoure");
        user.setPassword("mt123");

        given(userProfileService.findByUsernameAndPassword(user.getUsername(), user.getPassword())).willReturn(user);

        mvc.perform(MockMvcRequestBuilders
                .get("/users/mtoure/mt123")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isOk())
           .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(jsonPath("firstName", is("Mohamed")))
           .andExpect(jsonPath("lastName", is("Toure")));
    }
}
