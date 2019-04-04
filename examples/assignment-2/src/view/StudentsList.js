import React from "react";

const StudentsList = ({ students, title, firstName, lastName, 
    onCreate, onChange }) => (
    <div>
        <h2>{ title || "Students" }</h2>
        <div>
            <label>First Name: </label>
            <input value={firstName} 
                onChange={ e => onChange("firstName", e.target.value) } />
            <br />
            <label>Last Name: </label>
            <input value={lastName} 
                onChange={ e => onChange("lastName", e.target.value) } />
            <br />
            <button onClick={onCreate}>Create!</button>
        </div>
        <hr />
        <table border="1">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map((student, index) => (
                        <tr key={index}>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
);

export default StudentsList;