import React, { Component } from "react";
import model from "../model/model";

import StudentDetails from "./StudentDetails";

const mapModelStateToComponentState = modelState => (
    modelState.students[modelState.selectedStudentIndex]
)

export default class SmartStudentDetails extends Component {
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
            <StudentDetails
                firstName={this.state.firstName}
                lastName={this.state.lastName}
                grades={this.state.grades} />
        );
    }
}
