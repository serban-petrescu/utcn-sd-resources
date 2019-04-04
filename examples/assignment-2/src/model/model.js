import { EventEmitter } from "events";

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            students: [{
                firstName: "John",
                lastName: "Doe"
            }, {
                firstName: "Jack",
                lastName: "White"
            }],
            newStudent: {
                firstName: "",
                lastName: ""
            }
        };
    }

    addStudent(firstName, lastName) {
        this.state = {
            ...this.state,
            students: this.state.students.concat([{
                firstName: firstName,
                lastName: lastName
            }])
        };
        this.emit("change", this.state);
    }

    changeNewStudentProperty(property, value) {
        this.state = {
            ...this.state,
            newStudent: {
                ...this.state.newStudent,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }
}

const model = new Model();

export default model;