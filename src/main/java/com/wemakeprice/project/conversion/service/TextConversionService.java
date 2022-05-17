package com.wemakeprice.project.conversion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wemakeprice.project.conversion.dto.TextConversionRequest;
import com.wemakeprice.project.conversion.dto.TextConversionResponse;
import com.wemakeprice.project.conversion.util.TextDividor;
import com.wemakeprice.project.conversion.util.TextExtractor;

@Service
public class TextConversionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TextConversionService.class);
	
	/**
	 * 데이터 변환 서비스 로직
	 * @param request
	 * @return
	 */
	public TextConversionResponse conversion(TextConversionRequest request) {
		String targetText = new TextExtractor(request.getTargetText())
				.extractionAlphabetWithSort()
				.extractionNumberWithSort()
				.combine();
		
		TextDividor dividor = new TextDividor(targetText).divide(request.getOutputUnitSet());
		
		TextConversionResponse response = new TextConversionResponse();
		response.setQuotientText(dividor.getQuotientText());
		response.setRemainderText(dividor.getRemainderText());
		
		LOGGER.debug(response.toString());
		return response;
	}
	
}
