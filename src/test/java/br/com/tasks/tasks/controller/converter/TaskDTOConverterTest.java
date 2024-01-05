package br.com.tasks.tasks.controller.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tasks.tasks.utils.TestUtils;

@SpringBootTest
public class TaskDTOConverterTest
{

	@InjectMocks
	private TaskDTOConverter converter;

	@Test
	public void converter_mustReturnTaskDTO_whenInputTask()
	{
		final var task = TestUtils.buildValidTask();

		final var dto = this.converter.convert( task );
		Assertions.assertEquals( dto.getId(), task.getId() );
		Assertions.assertEquals( dto.getTitle(), task.getTitle() );
		Assertions.assertEquals( dto.getDescription(), task.getDescription() );
		Assertions.assertEquals( dto.getPriority(), task.getPriority() );
		Assertions.assertEquals( dto.getTaskState(), task.getTaskState() );
	}

	@Test
	public void converter_mustReturnTask_whenInputTask() {
		final var dto = TestUtils.buildValidTaskDTO();
		final var task = this.converter.convert( dto );
		Assertions.assertEquals( task.getId(), dto.getId() );
		Assertions.assertEquals( task.getTitle(), dto.getTitle() );
		Assertions.assertEquals( task.getDescription(), dto.getDescription() );
		Assertions.assertEquals( task.getPriority(), dto.getPriority() );
		Assertions.assertEquals( task.getTaskState(), dto.getTaskState() );
	}

	@Test
	public void converter_mustReturnTask_whenInputParameters()
	{
		final var dto = TestUtils.buildValidTaskDTO();
		final var task = this.converter.convert( dto.getId(), dto.getTitle(), dto.getDescription(), dto.getPriority(),
				dto.getTaskState() );
		Assertions.assertEquals( task.getId(), dto.getId() );
		Assertions.assertEquals( task.getTitle(), dto.getTitle() );
		Assertions.assertEquals( task.getDescription(), dto.getDescription() );
		Assertions.assertEquals( task.getPriority(), dto.getPriority() );
		Assertions.assertEquals( task.getTaskState(), dto.getTaskState() );
	}
}
