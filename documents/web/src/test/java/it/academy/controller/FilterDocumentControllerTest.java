package it.academy.controller;

import it.academy.utils.WebDocumentConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ContextConfiguration(classes = WebDocumentConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FilterDocumentControllerTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void home() throws Exception {
        final ModelAndView modelAndView = mockMvc
                .perform(get("/document/filter"))
                .andReturn()
                .getModelAndView();

        assertTrue(modelAndView.getModel().containsKey("name"));
        assertTrue(modelAndView.getModel().containsKey("whoCreate"));
        assertTrue(modelAndView.getModel().containsKey("author"));
        assertEquals("filter", modelAndView.getViewName());
    }

}