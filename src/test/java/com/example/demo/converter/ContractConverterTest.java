package com.example.demo.converter;

import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ContractConverterTest {

    @Test
    public void testConvertToEntity() {
        // Setup
        final ContractDTO contractDTO = null;

        // Run the test
        final Contract result = ContractConverter.convertToEntity(contractDTO);

        // Verify the results
        assertNotNull(result);
    }

    @Test
    public void testConvertToEntity1() {
        // Setup
        final List<ContractDTO> contractDTOList = Arrays.asList();
        final List<Contract> expectedResult = Arrays.asList();

        // Run the test
        final List<Contract> result = ContractConverter.convertToEntity(contractDTOList);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
