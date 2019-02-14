//package com.example.demo.converter;
//
//import com.example.demo.dto.ContractDTO;
//import com.example.demo.entity.Contract;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//
//import java.time.OffsetDateTime;
//import java.util.*;
//
//import static org.junit.Assert.*;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//public class ContractConverterTest {
//
//    @Mock
//    ContractConverter contractConverter;
//
//    @Before
//    public void setup(){
//        initMocks(this);
//    }
//
//    private List<ContractDTO> prepareContractDTOList() {
//        return new ArrayList<>(){{
//            add(new ContractDTO()
//                    .setId("a5ef4c3063d94b10a13630fa9cca90b9")
//                    .setDatePublished("2018-09-19T13:13:07.776613+03:00")
//                    .setDateModified("2018-09-19T13:13:07.776633+03:00")
//            );
//            add(new ContractDTO()
//                   .setId("4f6d6dc59d1844bb80143ccc2e727a2f")
//                   .setDatePublished("2018-09-19T13:12:21.136232+03:00")
//                   .setDateModified("2018-09-19T13:12:21.136263+03:00")
//           );
//
//        }};
//    }
//    private List<Contract> prepareContractList() {
//        return new ArrayList<>(){{
//            add(new Contract()
//                    .setUuid(UUID.fromString("A5EF4C30-63D9-4B10-A136-30FA9CCA90B9"))
//                    .setDatePublished(OffsetDateTime.parse("2018-09-19T13:13:07.776613+03:00"))
//                    .setDateModified(OffsetDateTime.parse("2018-09-19T13:13:07.776633+03:00"))
//            );
//            add(new Contract()
//                    .setUuid(UUID.fromString("4F6D6DC5-9D18-44BB-8014-3CCC2E727A2F"))
//                    .setDatePublished(OffsetDateTime.parse("2018-09-19T13:12:21.136232+03:00"))
//                    .setDateModified(OffsetDateTime.parse("2018-09-19T13:12:21.136263+03:00"))
//            );
//        }};
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConvertToEntity_Handle_Null_Object() {
//        ContractDTO contractDTO = null;
//        ContractConverter.convertToEntity(contractDTO);
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void convertToEntityList_Handle_EmptyList() {
//        ContractConverter.convertToEntityList(Collections.<ContractDTO>emptyList());
//    }
//
//    @Test
//    public void testConvertToEntity(){
//        Contract result = ContractConverter.convertToEntity(prepareContractDTOList().get(0));
//        assertEquals(prepareContractList().get(0),result);
//    }
//
//    @Test
//    public void testConvertToEntityList() {
//        List<Contract> result = ContractConverter.convertToEntityList(prepareContractDTOList());
//
//        assertEquals(prepareContractList(), result);
//    }
//}
