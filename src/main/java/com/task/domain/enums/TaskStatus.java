package com.task.domain.enums;

public enum TaskStatus {
	
	toDo(1),
	done(2),
	inProgress(3);
	
	private int code;
	
	private TaskStatus (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TaskStatus valueOf(int code) {
		for (TaskStatus value : TaskStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid TaskStatus code");
	}

}
