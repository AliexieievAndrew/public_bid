package com.example.demo.repository;

import com.example.demo.pojo.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, UUID> {

}
