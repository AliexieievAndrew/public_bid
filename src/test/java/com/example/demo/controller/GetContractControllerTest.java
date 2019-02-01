package com.example.demo.controller;

import com.example.demo.converter.ContractConverter;
import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @InjectMocks
    private GetContractController getContractControllerTest;

    private List<Contract> contractList;

    private List<ContractDTO> prepareContractDTOList() {
        return new ArrayList<>(){{
            add(new ContractDTO()
                    .setId("a5ef4c3063d94b10a13630fa9cca90b9")
                    .setDatePublished("2018-09-19T13:13:07.776613+03:00")
                    .setDateModified("2018-09-19T13:13:07.776633+03:00")
            );
            add(new ContractDTO()
                    .setId("4f6d6dc59d1844bb80143ccc2e727a2f")
                    .setDatePublished("2018-09-19T13:12:21.136232+03:00")
                    .setDateModified("2018-09-19T13:12:21.136263+03:00")
            );

        }};
    }

    @Value(value = "{$requestParam}")
    private String requestParam;

    @Before
    public void setUp() {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getContractControllerTest).build();

        contractList = Collections.singletonList(new Contract());;

        when(mockContractService.findAll())
                .thenReturn(contractList);
        when(mockContractService.findAllInExternalResource(requestParam))
                .thenReturn(prepareContractDTOList());
        when(mockContractService.saveAll(ContractConverter.convertToEntityList(prepareContractDTOList())))
                .thenReturn(ContractConverter.convertToEntityList(prepareContractDTOList()));
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
        System.out.println();
        String expectedResult = "redirect:/";
        String result = getContractControllerTest.getInfo(requestParam);

        assertEquals(expectedResult,result);

        verify(mockContractService,times(1))
                .findAllInExternalResource(requestParam);
        verify(mockContractService,times(1))
                .saveAll(ContractConverter.convertToEntityList(prepareContractDTOList()));
    }

    @Test
    public void testGetInfo_StatusRedirect() throws Exception {
        mockMvc.perform(get("/getInfo")
                .param("path",requestParam))
                .andDo(print())
                .andExpect(status().is(302));

        verify(mockContractService,times(1))
                .findAllInExternalResource(requestParam);
        verify(mockContractService,times(1))
                .saveAll(ContractConverter.convertToEntityList(prepareContractDTOList()));
    }
}