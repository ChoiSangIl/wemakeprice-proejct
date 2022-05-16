package com.wemakeprice.project.conversion.service;

import org.springframework.stereotype.Service;

import com.wemakeprice.project.conversion.dto.TextConversionRequest;
import com.wemakeprice.project.conversion.dto.TextConversionResponse;

@Service
public class TextConversionService {
	public TextConversionResponse conversion(TextConversionRequest request) {
		TextConversionResponse response = new TextConversionResponse();
		response.setQuotientText("abcde");
		return response;
	}
}
