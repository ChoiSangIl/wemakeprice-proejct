package com.wemakeprice.project.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wemakeprice.project.conversion.dto.TextConversionRequest;
import com.wemakeprice.project.conversion.dto.TextConversionResponse;
import com.wemakeprice.project.conversion.service.TextConversionService;


/**
 * 
 * Text 변환 컨트롤러
 * @author Choi Sang Il
 *
 */
@RestController
public class TextConversionController {
	
	private final TextConversionService textConversionService;
	
	@Autowired
	public TextConversionController(TextConversionService textConversionService) {
		this.textConversionService = textConversionService;
	}

	@PostMapping("/text/conversion")
	public TextConversionResponse translate(@RequestBody TextConversionRequest request) {
		return textConversionService.conversion(request);
	}
}
