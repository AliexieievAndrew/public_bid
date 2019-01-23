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

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Arrays;
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
    private List<ContractDTO> contractDTOList;

    private final String requestParam = "23567e24f52746ef92c470be6059d193";

    @Before
    public void setUp() throws IOException {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getContractControllerTest).build();

        contractList = Arrays.asList(new Contract());
        contractDTOList = Arrays.asList(new ContractDTO());

        when(mockContractService.findAll())
                .thenReturn(contractList);
        when(mockContractService.findAllInExternalResource(requestParam))
                .thenReturn(contractDTOList);
    }

    @Test
    public void testIndexReturnStringAndVerify(){
        String expectedResult = "index";
        String result = getContractControllerTest.index(model);
        assertEquals(expectedResult,result);

        verify(mockContractService,times(1)).findAll();
    }

    @Test
    public void testIndexStatusOk() throws Exception {
        mockMvc.perform(get("/home"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfoReturnStringAndVerify() throws IOException {
        String expectedResult = "redirect:/";

        String result = getContractControllerTest.getInfo(requestParam);
        assertEquals(expectedResult,result);
        verify(mockContractService,times(1)).findAllInExternalResource(requestParam);
    }
    @Test
    public void testGetInfoStatusRedirect() throws Exception {
        mockMvc.perform(get("/getInfo")
                .param("path",requestParam))
                .andDo(print())
                .andExpect(status().is(302));
    }
}