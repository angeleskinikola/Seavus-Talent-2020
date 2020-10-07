import React, { Component } from 'react';
import './App.css';
import PropTypes from 'prop-types';
import axios from 'axios';
import NotesGrid from './Note.jsx';
import Header from './Header.jsx';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import ManageTags from './ManageTags';

import CreateNote from './CreateNote';
import UpdateNote from './UpdateNote';
import FilterNotesByTag from './FilterNotesByTag';

function App() {
  return (
    
        <div> 
          <Header title="Seavus Notes" />
      
          <Switch>

            <Route path="/tags/:id/notes" component={FilterNotesByTag} />
          
            <Route path="/update-note/:id" component={UpdateNote} />
          
            <Route path="/create-note" component={CreateNote}/> 
          
            <Route path="/manage-tags" component={ManageTags}/>
          
            <Route path="/" component={NotesGrid}/>
          
          </Switch>

          <Link to="/create-note">
            <button className="add-note-button">+</button>
          </Link>
          
        </div>
      
    
    
  );
}

// function App() {
//   return (
//     <div> 
//       <Header title="Seavus Notes" />
      
//       <NotesGrid />
    
//       <button className="add-note-button">+</button>
//     </div>
    
//   );
// }

export default App;
