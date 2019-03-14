package ro.utcn.spet.example.a1.repository.data;

import org.springframework.data.repository.Repository;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.StudentRepository;

public interface DataStudentRepository extends Repository<Student, Integer>, StudentRepository {

	void delete(Student student);

	@Override
	default void remove(Student student) {
		delete(student);
	}
}
