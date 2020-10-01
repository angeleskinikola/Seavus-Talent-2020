import React, { Component } from 'react';

// Pretty much every application is going to need to do something with forms
// There are two ways to handle forms elements with React.
// First, there's Uncontrolled inputs. They're arguably easier, but less powerful.
//
// The basic idea of uncontrolled components is you pull the value out of the DOM
// element when you need it. To do this, you need to get a reference to the element.
// You can either get a reference via an event handler `event` argument (`event.target`),
// or by using the special `ref` prop on the element like so:
//
//     inputRef = React.createRef();
//     <input ref={this.inputRef} />
//
// From there you can reference the input node elsewhere in your component methods.
// For example, for taking out the value of the input, use this.inputRef.current.value

// Exercise:
// Render a CreateNoteForm component that will handle creating of a note with title and content.
// This component also needs to contain an onSubmit handler that when clicked alerts the value of an input of both input fields.
// For extracting the values of the input fields, use React Refs.
class CreateNoteForm extends Component {
    
    constructor(props) {
        super(props)
        this.titleInput = React.createRef();
        this.contentInput = React.createRef();
    }

    handleSubmit = (event) => {
        alert(`Title: ${this.titleInput.current.value}
Content: ${this.contentInput.current.value}` );
        event.preventDefault();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>title</label>
                <input type="text" ref={this.titleInput} />
                <label>content</label>
                <input type="text" ref={this.contentInput} />
                <input type="submit" value="Submit"/>
            </form>
        );
    }
}

export const Example = () => <CreateNoteForm />;
