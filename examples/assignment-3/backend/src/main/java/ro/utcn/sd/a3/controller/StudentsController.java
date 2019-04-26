package ro.utcn.sd.a3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.a3.dto.StudentDTO;
import ro.utcn.sd.a3.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentsController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> readAll() {
        return studentService.listAll();
    }

    @PostMapping("/students")
    public StudentDTO create(@RequestBody StudentDTO dto) {
        return studentService.create(dto);
    }
}
