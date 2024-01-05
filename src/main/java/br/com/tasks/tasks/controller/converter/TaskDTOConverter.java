package br.com.tasks.tasks.controller.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.tasks.tasks.controller.dto.TaskDTO;
import br.com.tasks.tasks.model.Task;
import br.com.tasks.tasks.model.TaskState;

@Component
public class TaskDTOConverter
{
	public TaskDTO convert( final Task task )
	{
		return Optional.ofNullable( task ).map( source -> {
			final var dto = new TaskDTO();
			dto.setId( source.getId() );
			dto.setTitle( source.getTitle() );
			dto.setDescription( source.getDescription() );
			dto.setPriority( source.getPriority() );
			dto.setTaskState( source.getTaskState() );
			return dto;
		} ).orElse( null );
	}

	public Task convert( final TaskDTO taskDto )
	{
		return Optional.ofNullable( taskDto )
				.map( sourcer -> Task.builder()
						.withId( sourcer.getId() )
						.withTitle( sourcer.getTitle() )
						.withDescription( sourcer.getDescription() )
						.withPriority( sourcer.getPriority() )
						.withState( sourcer.getTaskState() ).build() )
				.orElse( null );
	}

	public Task convert(final String id, final String title,final String description, final int priority, final TaskState taskState)
	{
		return Task.builder().withId( id )
				.withTitle( title )
				.withDescription( description )
				.withPriority( priority )
				.withState( taskState ).build();
	}
}
