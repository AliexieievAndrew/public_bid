package com.example.demo.client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestClientTest {

    private RestClient restClientUnderTest;

    @Before
    public void setUp() {
        restClientUnderTest = new RestClient();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoGetRequestUnexpectedURL() {
        String path = "dfsdf";
        restClientUnderTest.doGetRequest(path);
    }
    @Test(expected = NullPointerException.class)
    public void testDoGetRequestNull() {
        restClientUnderTest.doGetRequest(null);
    }
    @Test (expected = IllegalStateException.class)
    public void testDoGetRequestWrongPath() {
        String path = "https://lb-api-sandbox.prozorro.gov.ua/" +
                "api/2.4/contracts/23567e24f/documents";
        restClientUnderTest.doGetRequest(path);
    }

}
