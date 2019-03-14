package ro.utcn.spet.example.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.exception.StudentNotFoundException;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;
import ro.utcn.spet.example.a1.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentManagementService {
	private final RepositoryFactory repositoryFactory;

	@Transactional
	public List<Student> listStudents() {
		return repositoryFactory.createStudentRepository().findAll();
	}

	@Transactional
	public Student addStudent(String firstName, String lastName) {
		return repositoryFactory.createStudentRepository().save(new Student(firstName, lastName, null));
	}

	@Transactional
	public void updateEmailAddress(int id, String emailAddress) {
		StudentRepository repository = repositoryFactory.createStudentRepository();
		Student student = repository.findById(id).orElseThrow(StudentNotFoundException::new);
		student.setEmailAddress(emailAddress);
		repository.save(student);
	}

	@Transactional
	public void removeStudent(int id) {
		StudentRepository repository = repositoryFactory.createStudentRepository();
		Student student = repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.remove(student);
	}
}
