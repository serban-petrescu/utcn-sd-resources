import React from 'react';
import './App.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartStudentsList from './view/SmartStudentsList';
import SmartCreateStudent from './view/SmartCreateStudent';
import SmartStudentDetails from './view/SmartStudentDetails';

const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartStudentsList} path="/" />
        <Route exact={true} component={SmartCreateStudent} path="/create-student" />
        <Route exact={true} component={SmartStudentDetails} path="/student-details/:index" />
      </Switch>
    </HashRouter>
  </div>
);


export default App;
