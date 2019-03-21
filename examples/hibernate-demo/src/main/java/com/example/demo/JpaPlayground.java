package com.example.demo;

import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class JpaPlayground implements CommandLineRunner {
	private final EntityManagerFactory emf;

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting playground...");

		runWithEntityManager(em -> {
			Student student = new Student();
			student.setName("Whatever");
			student.setNumber("A123");
			em.persist(student);
			log.info(student.toString());
			return null;
		});

		Student other = runWithEntityManager(em -> {
			return em.find(Student.class, 1);
		});
		log.info(other.toString());
		log.info(other.getGrades().toString());

		runWithEntityManager(em -> {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			query.select(query.from(Student.class));
			List<Student> students = em.createQuery(query).getResultList();
			log.info(students.toString());
			return null;
		});
	}

	private <T> T runWithEntityManager(Function<EntityManager, T> callback) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			T t = callback.apply(em);
			em.getTransaction().commit();
			return t;
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

}
