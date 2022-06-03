package web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static web.TestData.TEST_STRING_JSON;
import static web.TestData.TEST_STRING_XML;

@SpringJUnitWebConfig(locations = {
        "classpath:spring-mvc.xml"
})
class ConvectorRestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void convertToJson() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/convert")
                .param("text_xml",TEST_STRING_XML)
        ).andReturn();

        String resultJson = result.getResponse().getContentAsString();
        Assert.isTrue(resultJson.equals(TEST_STRING_JSON),"Test is fail!");

    }

    @Test
    void convertFile() throws Exception {

        MvcResult result = mockMvc.perform(multipart("/convertFile")
                .file("file",TEST_STRING_XML.getBytes())).andReturn();

        String resultJson = result.getResponse().getContentAsString();
        Assert.isTrue(resultJson.equals(TEST_STRING_JSON),"Test is fail!");

    }
}