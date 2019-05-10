package ro.utcn.sd.a3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.a3.entity.Teacher;
import ro.utcn.sd.a3.service.TeacherUserDetailsService;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherUserDetailsService service;

    @GetMapping("/me")
    public Teacher readCurrent() {
        return service.loadCurrentTeacher();
    }
}
