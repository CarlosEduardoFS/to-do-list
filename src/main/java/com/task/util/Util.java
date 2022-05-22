package com.task.util;

import java.util.ArrayList;
import java.util.List;

import com.task.domain.Task;
import com.task.domain.enums.TaskStatus;

public class Util {
	
	public static List<Task> activeTasks (List<Task> list){
		List<Task> activeTasksList = new ArrayList<>();
		
		for (Task t : list) {
			if (t.getStatus() == TaskStatus.toDo.getCode()) {
				activeTasksList.add(t);
			}
		}
		return activeTasksList;
	}

}
