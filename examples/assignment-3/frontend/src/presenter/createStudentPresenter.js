import model from "../model/model";

class CreateStudentPresenter {

    onCreate() {
        model.addStudent(model.state.newStudent.firstName, model.state.newStudent.lastName)
            .then(() => {
                model.changeNewStudentProperty("firstName", "");
                model.changeNewStudentProperty("lastName", "");
                window.location.assign("#/");
            });
    }

    onChange(property, value) {
        model.changeNewStudentProperty(property, value);
    }

}

const createStudentPresenter = new CreateStudentPresenter();

export default createStudentPresenter;