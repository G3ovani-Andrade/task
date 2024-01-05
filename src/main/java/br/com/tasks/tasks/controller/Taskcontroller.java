package br.com.tasks.tasks.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasks.tasks.controller.converter.TaskDTOConverter;
import br.com.tasks.tasks.controller.dto.TaskDTO;
import br.com.tasks.tasks.model.TaskState;
import br.com.tasks.tasks.service.TaskService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
public class Taskcontroller
{
	private final TaskService service;
	private final TaskDTOConverter converter;

	public Taskcontroller( final TaskService service, final TaskDTOConverter converter )
	{
		this.service = service;
		this.converter = converter;
	}

	@GetMapping
	public Page<TaskDTO> getTasks( @RequestParam( required = false ) final String id,
			@RequestParam( required = false ) final String title,
			@RequestParam( required = false ) final String description,
			@RequestParam( required = false, defaultValue = "0" ) final int priority,
			@RequestParam( required = false ) final TaskState taskState,
			@RequestParam( defaultValue = "0", value = "pageNumber" ) final Integer pageNumber,
			@RequestParam( defaultValue = "10", value = "pageSize" ) final Integer pageSize )
	{
		System.out.println( pageNumber );
		System.out.println( pageSize );
		System.out.println( id );
		System.out.println( title );
		System.out.println( description );
		System.out.println( priority );
		System.out.println( taskState );
		return this.service
				.findPaginated( this.converter.convert( id, title, description, priority, taskState ), pageNumber,
						pageSize )
				.map( this.converter::convert );

	}

	@PostMapping
	public Mono<TaskDTO> createTask( @RequestBody final TaskDTO taskDTO )
	{
		return this.service.insertTask( this.converter.convert( taskDTO ) ).map( this.converter::convert );
	}

	@DeleteMapping("/{id}")
	@ResponseStatus( HttpStatus.NO_CONTENT )
	public Mono<Void> delete(@PathVariable final String id)
	{
		return Mono.just( id ).flatMap( this.service::deleteById );
	}
}
