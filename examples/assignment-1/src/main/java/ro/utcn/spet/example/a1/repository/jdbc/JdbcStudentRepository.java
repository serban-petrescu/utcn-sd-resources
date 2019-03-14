package ro.utcn.spet.example.a1.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcStudentRepository implements StudentRepository {
	private final JdbcTemplate template;

	@Override
	public List<Student> findAll() {
		return template.query("SELECT * FROM student", new StudentMapper());
	}

	@Override
	public Student save(Student student) {
		if (student.getId() == null) {
			student.setId(insert(student));
		} else {
			update(student);
		}
		return student;
	}

	@Override
	public void remove(Student student) {
		template.update("DELETE FROM student WHERE id = ?", student.getId());
	}

	@Override
	public Optional<Student> findById(int id) {
		List<Student> students = template.query("SELECT * FROM student WHERE id = ?", new StudentMapper(), id);
		return students.isEmpty() ? Optional.empty() : Optional.of(students.get(0));
	}

	private int insert(Student student) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
		insert.setTableName("student");
		insert.usingGeneratedKeyColumns("id");
		Map<String, Object> map = new HashMap<>();
		map.put("first_name", student.getFirstName());
		map.put("last_name", student.getLastName());
		map.put("email_address", student.getEmailAddress());
		return insert.executeAndReturnKey(map).intValue();
	}

	private void update(Student student) {
		template.update("UPDATE student SET first_name = ?, last_name = ?, email_address = ? WHERE id = ?",
				student.getFirstName(), student.getLastName(), student.getEmailAddress(), student.getId());
	}
}
