package br.com.tasks.tasks.controller.dto;

import br.com.tasks.tasks.model.TaskState;

public class TaskDTO
{
	private String id;
	private String title;
	private String description;
	private int priority;
	private TaskState taskState;

	public TaskDTO( final String id, final String title, final String description, final int priority,
			final TaskState taskState )
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.taskState = taskState;
	}

	public TaskDTO()
	{
	}

	public String getId()
	{
		return this.id;
	}

	public void setId( final String id )
	{
		this.id = id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle( final String title )
	{
		this.title = title;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription( final String description )
	{
		this.description = description;
	}

	public int getPriority()
	{
		return this.priority;
	}

	public void setPriority( final int priority )
	{
		this.priority = priority;
	}

	public TaskState getTaskState()
	{
		return this.taskState;
	}

	public void setTaskState( final TaskState taskState )
	{
		this.taskState = taskState;
	}


}
