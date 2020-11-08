import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AddProject from './components/Project/AddProject';

function App() {
  return (
    <Router>
      <div className="App">
        <Header/>
        <Dashboard />
        <Route path="/addProject" component={AddProject}/>
      </div>
    </Router>
  );
}

export default App;
 