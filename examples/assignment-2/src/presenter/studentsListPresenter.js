import model from "../model/model";

class StudentsListPresenter {

    onCreate() {
        model.addStudent(model.state.newStudent.firstName, model.state.newStudent.lastName);
        model.changeNewStudentProperty("firstName", "");
        model.changeNewStudentProperty("lastName", "");
    }

    onChange(property, value) {
        model.changeNewStudentProperty(property, value);
    }

}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;