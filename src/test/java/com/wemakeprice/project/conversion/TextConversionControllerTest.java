package com.wemakeprice.project.conversion;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wemakeprice.project.conversion.dto.TextConversionRequest;
import com.wemakeprice.project.conversion.dto.TextConversionResponse;
import com.wemakeprice.project.conversion.service.TextConversionService;

@WebMvcTest(controllers = TextConversionController.class)
@DisplayName("text 변환 컨트롤러 단위 테스트")
public class TextConversionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private TextConversionService textConversionService;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	@DisplayName("들어온 요청을 받아 줄 수 있다.")
	public void testTranslate() throws JsonProcessingException, Exception {
		//given
		TextConversionRequest request = new TextConversionRequest();
		request.setTargetText("c2b1a3A0");
		request.setOutputUnitSet(3);
		
		TextConversionResponse response = new TextConversionResponse();
		response.setQuotientText("A0a1b2");
		response.setRemainderText("c3");
		
		doReturn(response).when(textConversionService).conversion(any());
		
		//when
		mockMvc.perform(
				post("/text/conversion")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		)
		
		//then
		.andExpect(status().isOk())
		.andExpect(jsonPath("quotientText").value("A0a1b2"))
		.andExpect(jsonPath("remainderText").value("c3"));
	}

}
