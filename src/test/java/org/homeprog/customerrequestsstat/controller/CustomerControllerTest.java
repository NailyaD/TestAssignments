package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.config.TestConfig;
import org.homeprog.customerrequestsstat.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestConfig.class)
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testAddValidCustomer() throws Exception {

        mvc.perform(post("/api/customers")
                .content(VALID_CUSTOMER_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddInValidCustomer() throws Exception {
        mvc.perform(post("/api/customers")
                .content(INVALID_CUSTOMER_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    private static String VALID_CUSTOMER_JSON = "{\n" +
            " \"customerID\":1,\n" +
            " \"tagID\":2,\n" +
            " \"userID\":\"aaaaaaaa-bbbb-cccc-1111-222222222222\",\n" +
            " \"remoteIP\":\"123.234.56.78\"\n"+
            "}";

    private static String INVALID_CUSTOMER_JSON = "{\n" +
            " \"tagID\":2,\n" +
            " \"userID\":\"aaaaaaaa-bbbb-cccc-1111-222222222222\",\n" +
            " \"remoteIP\":\"123.234.56.78\"\n" +
            "}";
}


