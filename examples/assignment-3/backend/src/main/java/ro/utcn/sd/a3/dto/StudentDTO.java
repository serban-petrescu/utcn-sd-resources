package ro.utcn.sd.a3.dto;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import ro.utcn.sd.a3.entity.Grade;
import ro.utcn.sd.a3.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public static StudentDTO ofEntity(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        if (!CollectionUtils.isEmpty(student.getGrades())) {
            studentDTO.setGrades(student.getGrades().stream()
                    .map(Grade::getScore)
                    .collect(Collectors.toList()));
        }
        return studentDTO;
    }
}
