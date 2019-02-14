package com.example.demo.dto;

import com.example.demo.entity.Contract;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseContractDTO)) return false;
        ResponseContractDTO that = (ResponseContractDTO) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
