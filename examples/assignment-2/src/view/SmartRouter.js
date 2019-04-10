import React, { Component } from "react";
import model from "../model/model";
import Router from "./Router";

const mapModelStateToComponentState = modelState => ({
    route: modelState.route
});

export default class SmartRouter extends Component {
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
            <Router route={this.state.route} />
        );
    }
}
