import React, { Component } from "react";
import model from "../model/model";
import StudentsList from "./StudentsList";
import studentsListPresenter from "../presenter/studentsListPresenter";

const mapModelStateToComponentState = modelState => ({
    students: modelState.students,
    firstName: modelState.newStudent.firstName,
    lastName: modelState.newStudent.lastName
});

export default class SmartStudentsList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <StudentsList 
                onCreate={studentsListPresenter.onCreate}
                onChange={studentsListPresenter.onChange}
                firstName={this.state.firstName}
                lastName={this.state.lastName}
                students={this.state.students} />
        );
    }
}
