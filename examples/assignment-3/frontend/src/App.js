import React from 'react';
import './App.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartStudentsList from './view/SmartStudentsList';
import SmartCreateStudent from './view/SmartCreateStudent';

const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartStudentsList} path="/" />
        <Route exact={true} component={SmartCreateStudent} path="/create-student" />
      </Switch>
    </HashRouter>
  </div>
);


export default App;
