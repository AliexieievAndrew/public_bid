package com.example.demo.service;

import com.example.demo.client.RestClient;
import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
import com.example.demo.dto.DataDTO;
import com.example.demo.repository.ContractRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private ContractRepository contractRepository;

    @Value(value = "${externalUrlContractDoc}")
    private String externalUrl;

    public List<ContractDTO> findAllInExternalResource(String path) {

        if(StringUtils.isBlank(path)) {
            throw new IllegalArgumentException("path can not be empty");
        }

        String contractResponse = restClient.doGetRequest(String.format(externalUrl,path));

        return this.parseContractJSONResponse(contractResponse);
    }

    public Iterable<Contract> saveAll(List<Contract> contracts){
        return contractRepository.saveAll(contracts);
    }

    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    private List<ContractDTO> parseContractJSONResponse(String contractResponse)  {
        ObjectMapper mapper =  new ObjectMapper();
        DataDTO dataDTO = null;

        try {

            dataDTO = mapper.readValue(contractResponse, new TypeReference<DataDTO>(){});

        } catch (IOException e) {
            throw new IllegalStateException(String.format("contractResponse is: %s " +
                    "\nerror message: %s",
                    contractResponse,e.getMessage()));
        }
        return dataDTO.getData();
    }
}
