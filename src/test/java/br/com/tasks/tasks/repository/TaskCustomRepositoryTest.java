package br.com.tasks.tasks.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;

import br.com.tasks.tasks.utils.TestUtils;

@SpringBootTest
public class TaskCustomRepositoryTest
{
	@InjectMocks
	private TaskCustonRepository custonRepository;
	@Mock
	private MongoOperations mongoOperations;

	@Test
	public void customRepository_mustReturnPageWithOneElement_whenSendTask()
	{
		final var task = TestUtils.buildValidTask();
		Mockito.when( this.mongoOperations.find( ArgumentMatchers.any(), ArgumentMatchers.any() ) )
		.thenReturn( List.of( task ) );
		final var result = this.custonRepository.findPagenated( task, 0, 10 );
		Assertions.assertNotNull( result );
		Assertions.assertEquals( 1, result.getNumberOfElements() );
	}
}
