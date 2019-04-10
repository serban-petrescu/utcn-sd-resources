import React from "react";

const StudentDetails = ({ firstName, lastName, grades }) => (
    <div>
        <h2>Student</h2>
        <label>First Name: </label>
        <span>{ firstName }</span>
        <br />
        <label>Last Name: </label>
        <span>{ lastName }</span>
        <br />
        <ul>
            {
                grades.map((grade, index) => (
                    <li key={index}>
                    {
                        grade
                    }
                    </li>
                ))
            }
        </ul>
    </div>
);

export default StudentDetails;