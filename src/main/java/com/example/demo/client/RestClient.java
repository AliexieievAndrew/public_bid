package com.example.demo.client;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

public class RestClient {

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
                throw new IllegalStateException(String.format("Server responses with status is '%s'. " +
                                "\nLink: '%s'" +
                                "\nerror message: '%s'",
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
}