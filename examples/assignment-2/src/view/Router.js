import React from "react";
import SmartStudentsList from "./SmartStudentsList";
import SmartCreateStudent from "./SmartCreateStudent";
import SmartStudentDetails from "./SmartStudentDetails";

const Router = ({ route }) => (
    <div>
        {
            route === "students-list" ? <SmartStudentsList /> : 
            route === "create-student" ? <SmartCreateStudent /> :
            <SmartStudentDetails />
        }
    </div>
);

export default Router;