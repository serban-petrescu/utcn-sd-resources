package ro.utcn.sd.a3.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.entity.Grade;
import ro.utcn.sd.a3.entity.Student;
import ro.utcn.sd.a3.entity.Teacher;
import ro.utcn.sd.a3.repository.GradeRepository;
import ro.utcn.sd.a3.repository.StudentRepository;
import ro.utcn.sd.a3.repository.TeacherRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationSeed implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        Teacher serban = new Teacher(0, "serban", passwordEncoder.encode("password"));
        teacherRepository.save(serban);

        Student john = new Student(0, "John", "Doe", new LinkedList<>());
        studentRepository.save(john);
        Student jack = new Student(0, "Jack", "Black", new LinkedList<>());
        studentRepository.save(jack);
        Student jane = new Student(0, "Jane", "White", new LinkedList<>());
        studentRepository.save(jane);

        List<Grade> grades = Arrays.asList(
                new Grade(0, 5, LocalDate.now(), serban),
                new Grade(0, 6, LocalDate.now(), serban),
                new Grade(0, 7, LocalDate.now(), serban)
        );
        gradeRepository.saveAll(grades);

        john.setGrades(grades);
    }

    @Transactional
    public void clear() {
        gradeRepository.deleteAll();
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
    }
}
