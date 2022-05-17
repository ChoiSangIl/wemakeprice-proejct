package com.wemakeprice.project.conversion.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.wemakeprice.project.conversion.dto.TextConversionRequest;
import com.wemakeprice.project.conversion.dto.TextConversionResponse;

@DisplayName("텍스트 변환 서비스 단위 테스트")
public class TextConversionServiceTest {

	private static String TARGET_TEXT = "https://www.wemakeprice.co.kr/2b1a3A0"; 
	private static int OUTPUT_UNIT_TEXT = 20; 
	
	private final TextConversionService convsersionService = new TextConversionService();
	
	@Test
	@DisplayName("변환 서비스 로직 테스트")
	public void testConversion() {
		//given
		TextConversionRequest request = new TextConversionRequest();
		request.setTargetText(TARGET_TEXT);
		request.setOutputUnitSet(OUTPUT_UNIT_TEXT);
		
		//when
		TextConversionResponse response = convsersionService.conversion(request);
		
		//then
		Assertions.assertAll(
			()->{ Assertions.assertEquals(response.getQuotientText(), "A0a1a2b3cceeehikkmop"); },
			()->{ Assertions.assertEquals(response.getRemainderText(), "prrsttwwww"); }
		);
	}

}
