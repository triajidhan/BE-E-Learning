package com.lawencon.elearning.constant;

public enum Message {

	INSERT("Inserted"),
	UPDATE("Updated"),
	DELETE("Deleted");
	
	private String messageName;
	
	private Message(String messageName) {
		this.messageName = messageName;
	}

	public String getMessageName() {
		return messageName;
	}
}
