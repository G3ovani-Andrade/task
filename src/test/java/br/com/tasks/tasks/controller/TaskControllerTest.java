package br.com.tasks.tasks.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.tasks.tasks.controller.converter.TaskDTOConverter;
import br.com.tasks.tasks.model.Task;
import br.com.tasks.tasks.service.TaskService;

@SpringBootTest
public class TaskControllerTest
{
	@InjectMocks
	private Taskcontroller controller;

	@Mock
	private TaskService service;

	@Mock
	private TaskDTOConverter converter;

	//	@Test
	//	public void controller_mustReturnOk_whenSaveSucessfully()
	//	{
	//		Mockito.when( this.service.insertTask( ArgumentMatchers.any() ) ).thenReturn( Mono.just( new Task() ) );
	//		Mockito.when( this.converter.convert( ArgumentMatchers.any( Task.class ) ) ).thenReturn( new TaskDTO() );
	//
	//		final var client = WebTestClient.bindToController( this.controller ).build();
	//
	//		client.post()
	//		.uri( "/task" )
	//		.bodyValue( new TaskDTO() )
	//		.exchange()
	//		.expectStatus().isOk()
	//		.expectBody( TaskDTO.class );
	//
	//	}

	@Test
	public void controller_mustReturnOk_whenGetPaginatedSucessfully()
	{
		Mockito.when( this.service.findPaginated( ArgumentMatchers.any(), ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyInt() ) ).thenReturn( Page.empty() );


		final var client = WebTestClient.bindToController( this.controller ).build();

		client.get().uri( "/task" ).exchange().expectStatus().isOk().expectBody( Task.class );

	}

	//	@Test
	//	public void controller_mustRetunrNoContent_whenDeleteSucessfully()
	//	{
	//		final var taskId = "any_id";
	//		Mockito.when( this.service.deleteById( ArgumentMatchers.any() ) ).thenReturn( Mono.empty() );
	//		final var client = WebTestClient.bindToController( this.controller ).build();
	//
	//		client.delete().uri( "/task/" + taskId ).exchange().expectStatus().isNoContent();
	//	}

}
