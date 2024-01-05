package br.com.tasks.tasks.model;

import org.springframework.data.annotation.Id;

public class Task
{
	@Id
	private String id;
	private String title;
	private String description;
	private int priority;
	private TaskState taskState;

	

	public Task()
	{
		super();
	}

	public Task( final Builder builder )
	{
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.priority = builder.priority;
		this.taskState = builder.taskState;
	}

	public Task insert()
	{
		return Task.builderFrom( this )
				.withState( TaskState.INSERT )
				.build();
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getId()
	{
		return this.id;
	}

	public String getDescription()
	{
		return this.description;
	}

	public int getPriority()
	{
		return this.priority;
	}

	public TaskState getTaskState()
	{
		return this.taskState;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public static Builder builderFrom( final Task task )
	{
		return new Builder( task );
	}

	public static class Builder
	{
		private String id;
		private String title;
		private String description;
		private int priority;
		private TaskState taskState;

		public Builder()
		{

		}

		public Builder( final Task task )
		{
			this.id = task.id;
			this.title = task.title;
			this.description = task.description;
			this.priority = task.priority;
			this.taskState = task.taskState;
		}

		public Builder withTitle( final String title )
		{
			this.title = title;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withPriority(final int priority) {
			this.priority = priority;
			return this;
		}

		public Builder withState(final TaskState state)
		{
			this.taskState = state;
			return this;
		}

		public Builder withId( final String id )
		{
			this.id = id;
			return this;
		}

		public Task build()
		{
			return new Task( this );
		}
	}
}
