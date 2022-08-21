package com.campus.clova.controller;

public class SentimentVO {
	private String content;
	private String sentiment;
	
	
	private double negative;
	private double positive;
	private double neutral;
	
	private int offset;
	private int length;
	
	private int highOffset;
	private int highLength;
	
	@Override
	public String toString() {
		return "SentimentVO [content=" + content + ", sentiment=" + sentiment + ", negative=" + negative + ", positive="
				+ positive + ", neutral=" + neutral + ", offset=" + offset + ", length=" + length + ", highOffset="
				+ highOffset + ", highLength=" + highLength + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public double getNegative() {
		return negative;
	}
	public void setNegative(double negative) {
		this.negative = negative;
	}
	public double getPositive() {
		return positive;
	}
	public void setPositive(double positive) {
		this.positive = positive;
	}
	public double getNeutral() {
		return neutral;
	}
	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHighOffset() {
		return highOffset;
	}
	public void setHighOffset(int highOffset) {
		this.highOffset = highOffset;
	}
	public int getHighLength() {
		return highLength;
	}
	public void setHighLength(int highLength) {
		this.highLength = highLength;
	}
	
	
}
