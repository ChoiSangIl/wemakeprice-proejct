package com.wemakeprice.project.conversion.util;

/**
 * 
 * 문자열을 몫과 나머지로 나눈다
 * @author Choi Sang Il
 *
 */
public class TextDividor {
	
	private String originalText;
	
	private String quotientText;
	
	private String remainderText;
	
	private TextDividor() {
		throw new IllegalAccessError();
	}
	
	public TextDividor(String originalText) {
		this.originalText = originalText;
	}
	
	public TextDividor divide(int divide) {
		int textSize = originalText.length();
		if(textSize < divide) {
			this.quotientText = "";
			this.remainderText = originalText;
		}else {
			int remainder = textSize % divide;
			this.quotientText = originalText.substring(0, textSize-remainder);
			this.remainderText = originalText.substring(textSize-remainder, textSize);
		}
		
		return this;
	}

	public String getOriginalText() {
		return originalText;
	}

	public String getQuotientText() {
		return quotientText;
	}

	public String getRemainderText() {
		return remainderText;
	}
	
}
