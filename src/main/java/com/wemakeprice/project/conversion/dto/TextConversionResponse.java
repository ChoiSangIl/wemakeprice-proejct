package com.wemakeprice.project.conversion.dto;

/**
 * 
 * 변환 응답값
 * @author Choi Sang Il
 *
 */
public class TextConversionResponse {
	//변환 단위로 나눈 Text
	String quotientText;
	
	//변환 단위로 나누고 나온 나머지
	String remainderText;

	public String getQuotientText() {
		return quotientText;
	}

	public void setQuotientText(String quotientText) {
		this.quotientText = quotientText;
	}

	public String getRemainderText() {
		return remainderText;
	}

	public void setRemainderText(String remainderText) {
		this.remainderText = remainderText;
	}

	@Override
	public String toString() {
		return "TextConversionResponse [quotientText=" + quotientText + ", remainderText=" + remainderText + "]";
	}
}
