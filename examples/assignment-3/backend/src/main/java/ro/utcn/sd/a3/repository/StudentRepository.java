package ro.utcn.sd.a3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.a3.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
