package com.wemakeprice.project.conversion.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * text 추출 Class
 * 
 * @author Choi Sang Il
 *
 */
public class TextExtractor {

	private String originalText;
	
	private String alphabets = "";
	
	private String numbers = "";

	public TextExtractor(String targetText) {
		this.originalText = targetText;
	}

	/**
	 * originalText에서 알파벳을 추출하여 정렬한다
	 * @return
	 */
	public TextExtractor extractionAlphabetWithSort() {
		String result = "";
		Pattern nonValidPattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = nonValidPattern.matcher(this.originalText);
		while (matcher.find()) {
			result += matcher.group();
		}
		this.alphabets = sortStringAsc(result);
		return this;
	}
	
	/**
	 * originalText에서 숫자를 추출하여 정렬한다
	 * @return
	 */
	public TextExtractor extractionNumberWithSort() {
		this.numbers = sortStringFormatNumber(this.originalText.replaceAll("[^0-9]",""));
		return this;
	}
	
	/**
	 * 문자열 정렬
	 * @param target
	 * @return
	 */
	private String sortStringFormatNumber(String target) {
		char[] StringToChar = target.toCharArray();
		Arrays.sort(StringToChar);
		return new String(StringToChar);
	}

	/**
	 * input: CcaAbB -> output AaBbCc
	 * @param target
	 * @return
	 */
	private String sortStringAsc(String target) {
		return Arrays.stream(target.split("")).sorted((o1, o2) -> {
			int res = o1.compareToIgnoreCase(o2);
			return (res == 0) ? o1.compareTo(o2) : res;
		}).collect(Collectors.joining());
	}

	/**
	 * 추출한 단어를 합성한다.
	 * (a,b),(1,2) -> a1b2
	 * (a,b,c,d),(1,2) -> a1b2cd
	 * @return
	 */
	public String combine() {
		String result = "";
		int index = alphabets.length() >= numbers.length() ? alphabets.length() : numbers.length();
		for(int i=0; i<index; i++) {
			if(i<alphabets.length()) result = result + alphabets.charAt(i);
			if(i<numbers.length()) result = result + numbers.charAt(i);
		}
		return result;
	}
}
