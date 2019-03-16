package ro.utcn.spet.example.a1.repository.data;

import org.springframework.data.repository.Repository;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.StudentRepository;

// Spring Data JPA automatically implements this interface (because it extends the Repository interface)
// and generates the queries based on the method names
// check out https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.core-concepts
public interface DataStudentRepository extends Repository<Student, Integer>, StudentRepository {

	void delete(Student student);

	// needed due to different naming (Spring Data JPA uses delete, we defined a remove method instead).
	@Override
	default void remove(Student student) {
		delete(student);
	}
}
