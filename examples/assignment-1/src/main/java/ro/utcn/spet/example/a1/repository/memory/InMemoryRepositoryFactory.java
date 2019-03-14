package ro.utcn.spet.example.a1.repository.memory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;
import ro.utcn.spet.example.a1.repository.StudentRepository;

@Component
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "MEMORY")
public class InMemoryRepositoryFactory implements RepositoryFactory {
	private final InMemoryStudentRepository repository = new InMemoryStudentRepository();

	@Override
	public StudentRepository createStudentRepository() {
		return repository;
	}
}
