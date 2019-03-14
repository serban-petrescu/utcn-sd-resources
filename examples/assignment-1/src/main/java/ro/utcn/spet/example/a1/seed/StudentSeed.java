package ro.utcn.spet.example.a1.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;
import ro.utcn.spet.example.a1.repository.StudentRepository;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class StudentSeed implements CommandLineRunner {
	private final RepositoryFactory factory;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		StudentRepository repository = factory.createStudentRepository();
		if (repository.findAll().isEmpty()) {
			repository.save(new Student("A", "B", "A.B@example.com"));
			repository.save(new Student("C", "D", "C.D@example.com"));
			repository.save(new Student("E", "F", "E.F@example.com"));
		}
	}
}
