package com.example.demo.converter;

import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContractConverter {

    private final static String REGEX_UUID =
            "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)";

    private final static String REPLACEMENT_UUID = "$1-$2-$3-$4-$5";

    public static Contract convertToEntity(ContractDTO contractDTO) {

        if (contractDTO == null) {
            throw new IllegalArgumentException("ContractDTO is null");
        }

        ModelMapper modelMapper = new ModelMapper();
        Contract entity = modelMapper.map(contractDTO, Contract.class);

        entity.setUuid(
                UUID.fromString(contractDTO.getId()
                        .replaceFirst(REGEX_UUID, REPLACEMENT_UUID)
                )
        );

        entity.setDatePublished(OffsetDateTime.parse(contractDTO.getDatePublished()));
        entity.setDateModified(OffsetDateTime.parse(contractDTO.getDateModified()));

        return entity;
    }

    public static List<Contract> convertToEntityList(List<ContractDTO> contractDTOList) {

        if(contractDTOList == null || contractDTOList.isEmpty()) {
            throw new IllegalArgumentException("ContractDTO list is null or empty");
        }

        return contractDTOList
                .stream()
                .map(e -> convertToEntity(e)).collect(Collectors.toList());
    }
}
