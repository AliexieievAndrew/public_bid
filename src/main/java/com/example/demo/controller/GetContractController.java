package com.example.demo.controller;

import com.example.demo.converter.ContractConverter;
import com.example.demo.dto.ContractDTO;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class GetContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping(value = {"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "index";
    }


    @GetMapping(value = {"/getInfo"})
    public String getInfo(@RequestParam(value = "path") String path) {

        try {
            List<ContractDTO> founded = contractService.findAllInExternalResource(path);
            contractService.saveAll(ContractConverter.convertToEntity(founded));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
