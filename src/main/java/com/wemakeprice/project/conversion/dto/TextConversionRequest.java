package com.wemakeprice.project.conversion.dto;

/**
 * 
 * 변환 요청 객체
 * @author Choi Sang Il
 *
 */
public class TextConversionRequest {
	//target text
	String targetText;
	
	//출력단위묶음
	int outputUnitSet;

	public String getTargetText() {
		return targetText;
	}

	public void setTargetText(String targetText) {
		this.targetText = targetText;
	}

	public int getOutputUnitSet() {
		return outputUnitSet;
	}

	public void setOutputUnitSet(int outputUnitSet) {
		this.outputUnitSet = outputUnitSet;
	}

	@Override
	public String toString() {
		return "TextConversionRequest [targetText=" + targetText + ", outputUnitSet=" + outputUnitSet
				+ ", getTargetText()=" + getTargetText() + ", getOutputUnitSet()=" + getOutputUnitSet()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
