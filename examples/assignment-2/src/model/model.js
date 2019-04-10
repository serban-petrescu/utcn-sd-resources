import { EventEmitter } from "events";

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            students: [{
                firstName: "John",
                lastName: "Doe",
                grades: [10, 10, 9]
            }, {
                firstName: "Jack",
                lastName: "White",
                grades: [3, 4, 5]
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
                lastName: lastName,
                grades: []
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