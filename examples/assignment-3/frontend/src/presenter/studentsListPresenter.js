import model from "../model/model";

class StudentsListPresenter {
    onCreateStudent() {
        window.location.assign("#/create-student");
    }

    onInit() {
        model.loadStudents();
    }
}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;