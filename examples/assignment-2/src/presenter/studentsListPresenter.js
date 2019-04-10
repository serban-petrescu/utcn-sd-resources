import model from "../model/model";

class StudentsListPresenter {
    onCreateStudent() {
        window.location.assign("#/create-student");
    }

    onViewDetails(index) {
        window.location.assign("#/student-details/" + index);
    }
}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;