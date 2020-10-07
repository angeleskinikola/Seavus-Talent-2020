import React, { Component } from 'react';
import './App.css';
import NotesGrid from './components/Note.jsx';
import Header from './components/Header.jsx';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import ManageTags from './components/ManageTags.jsx';

import CreateNote from './components/CreateNote.jsx';
import UpdateNote from './components/UpdateNote.jsx';
import FilterNotesByTag from './components/FilterNotesByTag.jsx';

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
