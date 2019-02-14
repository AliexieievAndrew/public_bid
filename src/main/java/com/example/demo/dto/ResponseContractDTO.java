package com.example.demo.dto;

import com.example.demo.entity.Contract;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class ResponseContractDTO {
    @JsonProperty("data")
    private List<Contract> data;

    @JsonProperty("data")
    public List<Contract> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Contract> data) {
        this.data = data;
    }
}
