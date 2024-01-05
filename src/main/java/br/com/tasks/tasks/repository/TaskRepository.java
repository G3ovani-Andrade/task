package br.com.tasks.tasks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tasks.tasks.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>
{

}
