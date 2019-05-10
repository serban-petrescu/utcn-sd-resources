package ro.utcn.sd.a3.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.utcn.sd.a3.dto.StudentDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentCreatedEvent extends BaseEvent {
    private final StudentDTO student;

    public StudentCreatedEvent(StudentDTO student) {
        super(EventType.STUDENT_CREATED);
        this.student = student;
    }
}
