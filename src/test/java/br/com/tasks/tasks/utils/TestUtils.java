package br.com.tasks.tasks.utils;

import br.com.tasks.tasks.controller.dto.TaskDTO;
import br.com.tasks.tasks.model.Task;
import br.com.tasks.tasks.model.TaskState;

public class TestUtils
{
	public static Task buildValidTask()
	{
		return Task.builder().withId( "123" ).withTitle( "title" ).withDescription( "description" ).withPriority( 1 )
				.withState( TaskState.DONE ).build();
	}

	public static TaskDTO buildValidTaskDTO()
	{
		return new TaskDTO( "12334", "titleDTO", "descriptionDTO", 1, TaskState.INSERT );
	}
}
