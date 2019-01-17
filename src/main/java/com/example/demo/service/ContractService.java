package com.example.demo.service;

import com.example.demo.pojo.Contract;
import com.example.demo.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    private RestService restService;

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findAllInExternalResource(String path) throws IOException {

        String response = restService.doGetRequest(path);
        return restService.goResponse(response);
    }
}
