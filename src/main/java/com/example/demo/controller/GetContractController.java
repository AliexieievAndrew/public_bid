package com.example.demo.controller;

import com.example.demo.dto.ResponseContractDTO;
import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addInfo")
    public String addInfo(@RequestParam(value = "path") String path) {
        ResponseContractDTO allInExternalResource = contractService.processExternalResource(path);
        contractService.saveAll(allInExternalResource.getData());
        return "redirect:/";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Iterable<Contract> findAll() {
        return contractService.findAll();
    }
}
