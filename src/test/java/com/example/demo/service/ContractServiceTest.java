//package com.example.demo.service;
//
//import com.example.demo.PublicBidApplicationTests;
//import com.example.demo.client.RestClient;
//import com.example.demo.dto.ContractDTO;
//import com.example.demo.entity.Contract;
//import com.example.demo.repository.ContractRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//@TestPropertySource(locations = "classpath:application-test.properties")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PublicBidApplicationTests.class)
//public class ContractServiceTest {
//
//    @Mock
//    private RestClient mockRestClient;
//
//    @Mock
//    private ContractRepository mockContractRepository;
//
//    @InjectMocks
//    private ContractService contractServiceUnderTest;
//
//    @Value(value = "${resultJSON}")
//    private String resultJSON;
//
//    @Value(value = "${requestParam}")
//    private String requestParam;
//
//    @Value(value = "${externalUrlContractDoc}")
//    private String externalUrl;
//
//    private List<Contract> contractList;
//
//
//    private List<ContractDTO> prepareDTOList() {
//        return new ArrayList<>() {{
//            add(new ContractDTO()
//                    .setId("a5ef4c3063d94b10a13630fa9cca90b9")
//                    .setDatePublished("2018-09-19T13:13:07.776613+03:00")
//                    .setDateModified("2018-09-19T13:13:07.776633+03:00")
//            );
//        }};
//    }
//
//    @Before
//    public void setUp() {
//        initMocks(this);
//        contractList = Collections.singletonList(new Contract());
//
//        ReflectionTestUtils.setField(contractServiceUnderTest,
//                "externalUrl",
//                externalUrl);
//
//        when(mockContractRepository.findAll()).thenReturn(contractList);
//        when(mockContractRepository.saveAll(contractList)).thenReturn(contractList);
//
//    }
//
//    @Test
//    public void testFindAllInExternalResource() {
//        when(mockRestClient.doGetRequest(String.format(externalUrl,requestParam))).thenReturn(resultJSON);
//        List<ContractDTO> result = contractServiceUnderTest.processExternalResource(requestParam);
//
//        assertEquals(prepareDTOList(), result);
//        verify(mockRestClient,times(1)).doGetRequest(String.format(externalUrl,requestParam));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testFindAllInExternalResource_Null_or_Blank() {
//        String blank = " ";
//        contractServiceUnderTest.processExternalResource(blank);
//    }
//
//    @Test
//    public void testFindAll(){
//        Iterable<Contract> result = contractServiceUnderTest.findAll();
//        assertEquals(contractList,result);
//        verify(mockContractRepository,times(1)).findAll();
//    }
//
//    @Test
//    public void testSaveAll() {
//        contractServiceUnderTest.saveAll(contractList);
//        verify(mockContractRepository,times(1)).saveAll(contractList);
//    }
//}
