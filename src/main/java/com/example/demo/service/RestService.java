package com.example.demo.service;

import com.example.demo.pojo.Contract;
import com.example.demo.pojo.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RestService {
    private OkHttpClient httpClient = new OkHttpClient();

    public String doGetRequest(String path) {
        Request request = new Request.Builder()
                .url(path)
                .build();
        return executeResponse(request, path);
    }

    private String executeResponse(Request request, String path) {

        try(Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IllegalStateException(String.format("Server responses with status is '%s'. \nLink: '%s'\nerror message: '%s'",
                        response.code(), path, response.message()));
            }

            if(response.body() == null) {
                throw new IllegalStateException("Response is null");
            }
            return response.body().string();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public List<Contract> goResponse(String string) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(string, new TypeReference<Data>(){});
        return data.getData();
    }
}