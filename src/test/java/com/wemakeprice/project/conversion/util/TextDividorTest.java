package com.wemakeprice.project.conversion.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TextDividor Test")
public class TextDividorTest {

	@Test
	@DisplayName(value = "1로 나눴을때는 전체가 나와야한다.")
	public void divide_1() {
		//when
		TextDividor dividor = new TextDividor("123456789").divide(1);
		
		//then
		Assertions.assertEquals(dividor.getQuotientText(), "123456789");
	}
	
	@Test
	@DisplayName(value = "나누고자 하는 값이 더 크면 몫이 0이므로 전체 문자는 나머지로 가야한다.")
	public void divide_big() {
		//when
		TextDividor dividor = new TextDividor("123456789").divide(100);
		
		//then
		Assertions.assertAll(
			()->{ Assertions.assertEquals(dividor.getQuotientText(), ""); },
			()->{ Assertions.assertEquals(dividor.getRemainderText(), "123456789"); }
		);
	}
	
	@Test
	@DisplayName(value = "공백이 들어와도 나눠져야한다.")
	public void divide_blank() {
		//when
		TextDividor dividor = new TextDividor("1234 56789").divide(3);
		
		//then
		Assertions.assertAll(
			()->{ Assertions.assertEquals(dividor.getQuotientText(), "1234 5678"); },
			()->{ Assertions.assertEquals(dividor.getRemainderText(), "9"); }
		);
	}
	
	@Test
	@DisplayName(value = "특수문자도 이상없이 나눠져야한다.")
	public void divide_special_character() {
		//when
		TextDividor dividor = new TextDividor("!@#$%! abcd ").divide(7);
		
		//then
		Assertions.assertAll(
			()->{ Assertions.assertEquals(dividor.getQuotientText(), "!@#$%! "); },
			()->{ Assertions.assertEquals(dividor.getRemainderText(), "abcd "); }
		);
	}

}
