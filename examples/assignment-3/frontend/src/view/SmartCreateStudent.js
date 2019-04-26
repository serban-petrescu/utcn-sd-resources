import React, { Component } from "react";
import model from "../model/model";

import CreateStudent from "./CreateStudent";
import createStudentPresenter from "../presenter/createStudentPresenter";

const mapModelStateToComponentState = modelState => ({
    firstName: modelState.newStudent.firstName,
    lastName: modelState.newStudent.lastName
});

export default class SmartCreateStudent extends Component {
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
            <CreateStudent 
                onCreate={createStudentPresenter.onCreate}
                onChange={createStudentPresenter.onChange}
                firstName={this.state.firstName}
                lastName={this.state.lastName} />
        );
    }
}
