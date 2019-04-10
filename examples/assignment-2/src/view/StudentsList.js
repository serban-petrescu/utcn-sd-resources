import React from "react";

const StudentsList = ({ students, title, onCreateStudent, onViewDetails }) => (
    <div>
        <h2>{ title || "Students" }</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map((student, index) => (
                        <tr key={index}>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td><button onClick={() => onViewDetails(index)}>View Details</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <button onClick={onCreateStudent}>Add new Student</button>
    </div>
);

export default StudentsList;