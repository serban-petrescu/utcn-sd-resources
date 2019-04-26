package ro.utcn.sd.a3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.dto.StudentDTO;
import ro.utcn.sd.a3.entity.Student;
import ro.utcn.sd.a3.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public List<StudentDTO> listAll() {
        return studentRepository.findAll().stream()
                .map(StudentDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public StudentDTO create(StudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        return StudentDTO.ofEntity(studentRepository.save(student));
    }

}
