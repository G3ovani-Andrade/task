package br.com.tasks.tasks.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.tasks.tasks.model.Task;
import br.com.tasks.tasks.repository.TaskCustonRepository;
import br.com.tasks.tasks.repository.TaskRepository;
import reactor.core.publisher.Mono;

@Service
public class TaskService
{

	private final TaskRepository taskRepository;
	private final TaskCustonRepository custonRepository;

	public TaskService( final TaskRepository taskRepository, final TaskCustonRepository custonRepository )
	{
		this.taskRepository = taskRepository;
		this.custonRepository = custonRepository;
	}

	public Mono<Task> insertTask( final Task task )
	{
		return Mono.just( task )
				.map( Task::insert )
				.flatMap( this::save );
	}

	public Mono<List<Task>> list()
	{
		return Mono.just( this.taskRepository.findAll() );
	}

	private Mono<Task> save( final Task task )
	{
		return Mono.just( task )
				.map( this.taskRepository::save );
	}

	public Page<Task> findPaginated( final Task task, final Integer pageNumber, final Integer pageSize )
	{
		return this.custonRepository.findPagenated( task, pageNumber, pageSize );
	}

	public Mono<Void> deleteById( final String id )
	{
		return Mono.fromRunnable( () -> this.taskRepository.deleteById( id ) );
	}
}
