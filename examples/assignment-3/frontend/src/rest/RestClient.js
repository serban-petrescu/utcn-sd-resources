const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllStudents() {
        return fetch(BASE_URL + "/students", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createStudent(firstName, lastName) {
        return fetch(BASE_URL + "/students", {
            method: "POST",
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }
}