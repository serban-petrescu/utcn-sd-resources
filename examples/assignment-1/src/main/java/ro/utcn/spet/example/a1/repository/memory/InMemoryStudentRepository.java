package ro.utcn.spet.example.a1.repository.memory;

import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryStudentRepository implements StudentRepository {
	// we want to be thread-safe, because this class will be a singleton (just one instance)
	// in order to not use synchronized methods, we use thread-safe classes (ConcurrentHashMap and AtomicInteger)
	private final Map<Integer, Student> data = new ConcurrentHashMap<>();
	private final AtomicInteger currentId = new AtomicInteger(0);

	@Override
	public Student save(Student student) {
		if (student.getId() == null) {
			student.setId(currentId.incrementAndGet());
		}
		data.put(student.getId(), student);
		return student;
	}

	@Override
	public void remove(Student student) {
		data.remove(student.getId());
	}

	@Override
	public Optional<Student> findById(int id) {
		return Optional.ofNullable(data.get(id));
	}

	@Override
	public List<Student> findAll() {
		return new ArrayList<>(data.values());
	}
}
