package ro.utcn.spet.example.a1.repository.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateStudentRepository implements StudentRepository {
	private final EntityManager entityManager;

	@Override
	public List<Student> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		query.select(query.from(Student.class));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Student save(Student student) {
		if (student.getId() == null) {
			entityManager.persist(student);
			return student;
		} else {
			return entityManager.merge(student);
		}
	}

	@Override
	public void remove(Student student) {
		entityManager.remove(student);
	}

	@Override
	public Optional<Student> findById(int id) {
		return Optional.ofNullable(entityManager.find(Student.class, id));
	}
}
