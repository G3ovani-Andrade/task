package br.com.tasks.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication
{
	public static void main( final String[] args )
	{
		SpringApplication.run(TasksApplication.class, args);
		System.out.println( "ola4" );
	}
}
