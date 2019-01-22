package com.example.demo.converter;

import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
import org.modelmapper.ModelMapper;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContractConverter {

    public static Contract convertToEntity (ContractDTO contractDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Contract entity = modelMapper.map(contractDTO, Contract.class);
        entity.setUuid(
                UUID.fromString(contractDTO.getId()
                        .replaceFirst(
                                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                                "$1-$2-$3-$4-$5"
                        )
                )
        );
        entity.setDatePublished(OffsetDateTime.parse(contractDTO.getDatePublished()));
        entity.setDateModified(OffsetDateTime.parse(contractDTO.getDateModified()));
        return entity;
    }
    public static List<Contract> convertToEntity (List<ContractDTO> contractDTOList) {
        return contractDTOList
                .stream()
                .map(e -> convertToEntity(e)).collect(Collectors.toList());
    }
}
