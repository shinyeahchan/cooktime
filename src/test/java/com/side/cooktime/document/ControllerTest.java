package com.side.cooktime.document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.side.cooktime.domain.category.controller.CategoryController;
import org.junit.jupiter.api.Disabled;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

@Disabled
@WebMvcTest({
        CategoryController.class
})
@MockBean(JpaMetamodelMappingContext.class)
public abstract class ControllerTest {

    @Autowired
    public ObjectMapper objectMapper;
    @Autowired
    public MockMvc mockMvc;
    @Autowired
    public CategoryController categoryController;

    public String createJson(Object dto) throws JsonProcessingException{
        return objectMapper.writeValueAsString(dto);
    }
}
