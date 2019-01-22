package com.example.demo.service;

import com.example.demo.client.RestClient;
import com.example.demo.dto.ContractDTO;
import com.example.demo.pojo.Contract;
import com.example.demo.dto.DataDTO;
import com.example.demo.repository.ContractRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private ContractRepository contractRepository;

    public List<ContractDTO> findAllInExternalResource(String path) throws IOException {

        String contractResponse = restClient.doGetRequest(path);
        return this.parseContractJSONResponse(contractResponse);
    }

    public void saveAll(List<Contract> contracts){
        contractRepository.saveAll(contracts);
    }
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    private List<ContractDTO> parseContractJSONResponse(String contractResponse) throws IOException {
        ObjectMapper mapper =  new ObjectMapper();
        DataDTO dataDTO = mapper.readValue(contractResponse, new TypeReference<DataDTO>(){});
        return dataDTO.getData();
    }
}
