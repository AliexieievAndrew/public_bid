package com.example.demo.client;

import com.example.demo.PublicBidApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@TestPropertySource(locations= "classpath:application-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PublicBidApplicationTests.class)
public class RestClientTest {


    @Value(value = "${illegalPath}")
    private String illegalPath;

    @Value(value = "${externalUrlContractDocCollect}")
    private String externalUrlContractDocCollect;

    @Value(value = "${fullJSON}")
    private String fullJSON;

    @InjectMocks
    private RestClient restClientUnderTest;

    @Test
    public void testDoGetRequest_Matcher_RealWork() {
        String result = restClientUnderTest.doGetRequest(externalUrlContractDocCollect);
        assertThat(result, is(fullJSON));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoGetRequest_Null_or_Blank() {
        restClientUnderTest.doGetRequest(" ");
    }

    @Test(expected = IllegalStateException.class)
    public void testDoGetRequest_IllegalPath_404(){
        restClientUnderTest.doGetRequest(illegalPath);
    }
}
