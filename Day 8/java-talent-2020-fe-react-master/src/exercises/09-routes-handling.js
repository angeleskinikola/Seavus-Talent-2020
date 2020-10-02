import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

// Pretty much every application is going to need to do something with navigation and routes handling. 
// Since React doesn't include routing mechanism we will use additional library named 'react-router'. 
// As you can see in this application there is already Routing defined and on each exercise the path in the browser 
// changes accordingly. 
// If you open App.js component you can see that our whole application is wrapped in </BrowserRouter> component provided by 'react-router' library.

// Exercise: 
//   Create a Routes component that will define a </Route> for '/edit-note' and </Route> for '/create-note'.
//   This Routes component besides the Routes also needs to include </Link> in order to navigate to your defined </Route> 
//   When user clicks on "Create Note" or "Edit Note" </Link>, we need to render the </CreateNote> or </EditNote>  component defined bellow.
//   Make sure that you use the current path '/exercise/routes-handling' when defining your custom Routes.

function Routes() {
    return (
        <Router>
            <Link to="/exercise/routes-handling/edit-note"> Edit Note </Link>
            <br/>
            <Link to="/exercise/routes-handling/create-note"> Create Note </Link>
            <br/>
            <Switch>
                <Route path="/exercise/routes-handling/edit-note">
                    <EditNote />
                </Route>
                <Route path="/exercise/routes-handling/create-note">
                    <CreateNote />
                </Route>
            </Switch>
        </Router>
    );
}

function EditNote() {
    return 'Edit Note Component';
}

function CreateNote() {
    return 'Create Note Component';
}


export const Example = () => <Routes />;
