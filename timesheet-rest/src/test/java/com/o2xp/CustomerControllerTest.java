package com.o2xp;

import com.o2xp.controller.CustomerController;
import com.o2xp.model.Customer;
import com.o2xp.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void mustFindMoreThanOneCustomer() throws Exception {
        Customer customer = new Customer();

        customer.setName("Clearstream");
        customer.setReference("CS12345");

        List<Customer> customers = Arrays.asList(customer);
        given(customerService.findAll()).willReturn(customers);

        mvc.perform(MockMvcRequestBuilders
                .get("/customers")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isOk());
    }
}
