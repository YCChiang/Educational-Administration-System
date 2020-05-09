package service.impl;

public class Massage {
	private boolean IsError;
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIsError() {
		return IsError;
	}
	public void setIsError(boolean isError) {
		IsError = isError;
	}
}
