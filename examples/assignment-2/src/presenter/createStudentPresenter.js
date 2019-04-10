import model from "../model/model";

class CreateStudentPresenter {

    onCreate() {
        model.addStudent(model.state.newStudent.firstName, model.state.newStudent.lastName);
        model.changeNewStudentProperty("firstName", "");
        model.changeNewStudentProperty("lastName", "");
        model.changeRoute("students-list");
    }

    onChange(property, value) {
        model.changeNewStudentProperty(property, value);
    }

}

const createStudentPresenter = new CreateStudentPresenter();

export default createStudentPresenter;