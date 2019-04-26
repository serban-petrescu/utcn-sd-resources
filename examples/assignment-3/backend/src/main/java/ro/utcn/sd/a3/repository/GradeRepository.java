package ro.utcn.sd.a3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.a3.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
