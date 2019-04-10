import model from "../model/model";

class StudentsListPresenter {
    onCreateStudent() {
        model.changeRoute("create-student");
    }

    onViewDetails(index) {
        model.changeSelectedStudentIndex(index);
        model.changeRoute("student-details");
    }
}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;