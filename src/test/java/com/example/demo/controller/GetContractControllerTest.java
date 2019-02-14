package com.example.demo.controller;

import com.example.demo.dto.ResponseContractDTO;
import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class GetContractControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ContractService mockContractService;

    @Mock
    private Model model;

    @Mock
    private ResponseContractDTO allInExternalResource;

    @InjectMocks
    private GetContractController getContractControllerTest;

    private List<Contract> contractList;

    @Value(value = "{$requestParam}")
    private String requestParam;

    @Before
    public void setUp() {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getContractControllerTest).build();

        contractList = Collections.singletonList(new Contract());;

        when(mockContractService.findAll())
                .thenReturn(contractList);
        when(mockContractService.processExternalResource(requestParam))
                .thenReturn(allInExternalResource);
        when(mockContractService.saveAll(allInExternalResource.getData()))
                .thenReturn(contractList);
    }

    @Test
    public void testIndex_Match_Returning_String(){
        String expectedResult = "index";
        String result = getContractControllerTest.index(model);

        assertEquals(expectedResult, result);
        verify(mockContractService, times(1)).findAll();
    }

    @Test
    public void testIndex_StatusIsOk_And_Check_ForwardedURL() throws Exception {
        mockMvc.perform(get("/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("index"));

        verify(mockContractService, times(1)).findAll();
    }

    @Test
    public void testGetInfo_Match_Returning_String() {
        String expectedResult = "redirect:/";
        String result = getContractControllerTest.addInfo(requestParam);

        assertEquals(expectedResult,result);

        verify(mockContractService,times(1))
                .processExternalResource(requestParam);
        verify(mockContractService,times(1))
                .saveAll(allInExternalResource.getData());
    }

    @Test
    public void testGetInfo_StatusRedirect() throws Exception {
        mockMvc.perform(get("/addInfo")
                .param("path",requestParam))
                .andDo(print())
                .andExpect(status().is(302));

        verify(mockContractService,times(1))
                .processExternalResource(requestParam);
        verify(mockContractService,times(1))
                .saveAll(allInExternalResource.getData());
    }
}