package service.impl;

public class Massage {
	private boolean error;
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isError() {
		return error;
	}
	public void setIsError(boolean isError) {
		error = isError;
	}
}
