import React, { Component } from "react";
import model from "../model/model";
import StudentsList from "./StudentsList";
import studentsListPresenter from "../presenter/studentsListPresenter";

const mapModelStateToComponentState = modelState => ({
    students: modelState.students
});

export default class SmartStudentsList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
        studentsListPresenter.onInit();
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <StudentsList 
                onCreateStudent={studentsListPresenter.onCreateStudent}
                students={this.state.students} />
        );
    }
}
