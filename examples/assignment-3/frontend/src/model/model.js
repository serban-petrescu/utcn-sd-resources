import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("serban", "password");

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            students: [],
            newStudent: {
                firstName: "",
                lastName: ""
            }
        };
    }

    loadStudents() {
        return client.loadAllStudents().then(students => {
            this.state = { 
                ...this.state, 
                students: students 
            };
            this.emit("change", this.state);
        })
    }

    addStudent(firstName, lastName) {
        return client.createStudent(firstName, lastName)
            .then(student => {
                this.state = { 
                    ...this.state, 
                    students: this.state.students.concat([student]) 
                };
                this.emit("change", this.state);
            });
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