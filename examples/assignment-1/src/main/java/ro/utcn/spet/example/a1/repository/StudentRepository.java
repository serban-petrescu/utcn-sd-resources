package ro.utcn.spet.example.a1.repository;

import ro.utcn.spet.example.a1.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
	List<Student> findAll();
	Student save(Student student);
	void remove(Student student);
	Optional<Student> findById(int id);
}
