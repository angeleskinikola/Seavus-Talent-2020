import React from 'react';
import PropTypes from 'prop-types';

// So far we've just been using function components.
// Now that we need to worry about state in our component, we need to use the ES6 class syntax.
// To turn an ES6 class into a React component, you extend React.Component
// (or `import {Component} from 'react'` and use that)
//
// Exercise:
//
// Our EditNote component needs to have two input fields for title and content. 
// Changes on this fields needs to be saved in the local component state and displayed on the screen.
class EditNote extends React.Component {
    state = {
                title : '',
                content : ''
            }
    
    setTitle = (e) => {
        this.setState({title: e.target.value})
    }        

    setContent = (e) => {
        this.setState({content: e.target.value})
    }

    render() {
        return <div>
           <label>title</label> <input type="text" onChange={ this.setTitle } />
           <label>content</label> <input type="text" onChange={ this.setContent } />
           <hr/>
            <p>title: { this.state.title }</p>
            <hr/>
            <p>content: { this.state.content }</p>
        </div>;
    }
}

export const Example = () => <EditNote/>;