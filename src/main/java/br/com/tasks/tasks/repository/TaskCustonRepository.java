package br.com.tasks.tasks.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import br.com.tasks.tasks.model.Task;

@Repository
public class TaskCustonRepository
{
	private final MongoOperations mongoOperations;

	public TaskCustonRepository( MongoOperations mongoOperations )
	{
		this.mongoOperations = mongoOperations;
	}

	public Page<Task> findPagenated( Task task, Integer page, Integer size )
	{
		Pageable pageable = PageRequest.of( page, size, Sort.by( "title" ).ascending() );
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths( "priority", "state" );

		Example<Task> example = Example.of( task, matcher );

		Query query = Query.query( Criteria.byExample( example ) ).with( pageable );

		if ( task.getPriority() > 0 )
		{
			query.addCriteria( Criteria.where( "priority" ).is( task.getPriority() ) );
		}
		if ( task.getTaskState() != null )
		{
			query.addCriteria( Criteria.where( "state" ).is( task.getTaskState() ) );
		}

		return PageableExecutionUtils.getPage( this.mongoOperations.find( query, Task.class ), pageable,
				() -> this.mongoOperations.count( query, Task.class ) );
	}

}
