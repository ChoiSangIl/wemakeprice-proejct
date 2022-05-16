package com.wemakeprice.project.conversion.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TextExtractor util 객체 테스트")
public class TextExtractorTest {
	
	@Test
	@DisplayName("특수문자와 영어 숫자가 들어올 경우")
	public void TextExtractorTest_Senario1() {
		//given
		String targetString = "김#z0Aaa17bBZA?";
		
		//when
		String result = new TextExtractor(targetString)
			.extractionAlphabetWithSort()
			.extractionNumberWithSort()
			.combine();
		
		//then
		assertEquals(result, "A0A1a7aBbZz");
	}
	
	@Test
	@DisplayName("url 형태로 들어올 경우(대문자포함)")
	public void TextExtractorTest_Senario_weburl() {
		//given
		String targetString = "https://test.co.kr/AA/123456";
		
		//when
		String result = new TextExtractor(targetString)
			.extractionAlphabetWithSort()
			.extractionNumberWithSort()
			.combine();
		
		//then
		assertEquals(result, "A1A2c3e4h5k6oprsstttt");
	}
	
	@Test
	@DisplayName("숫자만 들어올 경우")
	public void TextExtractorTest_Senario_onlyNumber() {
		//given
		String targetString = "87612346";
		
		//when
		String result = new TextExtractor(targetString)
			.extractionAlphabetWithSort()
			.extractionNumberWithSort()
			.combine();
		
		//then
		assertEquals(result, "12346678");
	}
	
	@Test
	@DisplayName("문자만 들어올 경우")
	public void TextExtractorTest_Senario_onlyString() {
		//given
		String targetString = "helloword";
		
		//when
		String result = new TextExtractor(targetString)
			.extractionAlphabetWithSort()
			.extractionNumberWithSort()
			.combine();
		
		//then
		assertEquals(result, "dehlloorw");
	}
	
	/**
	 * 값이 안들어온다면 오류를 내줘야 하는게 좋을까?
	 */
	@Test
	@DisplayName("아무값이 안들어온다면?")
	public void TextExtractorTest_Senario_inputNull() {
		//given
		String targetString = "";
		
		//when
		String result = new TextExtractor(targetString)
			.extractionAlphabetWithSort()
			.extractionNumberWithSort()
			.combine();
		
		//then
		assertEquals(result, "");
	}

}
