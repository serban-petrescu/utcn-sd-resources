import React from "react";

const StudentsList = ({ students, title, onCreateStudent }) => (
    <div>
        <h2>{ title || "Students" }</h2>
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
                        <tr key={index} data-cy="student">
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <button onClick={onCreateStudent} data-cy="add">Add new Student</button>
    </div>
);

export default StudentsList;