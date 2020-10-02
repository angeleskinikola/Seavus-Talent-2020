import React, { Component } from 'react';

// For controlled components, the idea is that you push the values from the component
// to the consumer via callback handlers. In the context of a form, this is normally
// via `onChange` which receives the `event` (and you can get the value via
// `event.target.value`) like so:
//
//     <input onChange={event => console.log(event.target.value)} />
//
// In this scenario, you also need to provide the value for the input like so:
//
//     <input value={this.state.value} />
//
// This gives you a lot more power over the input. 

// Exercise:
//   Render a EditNote form with an onSubmit handler that alerts the value of both title and content
//   while saving their data in the local component state
//   The submit button needs to be disabled if there is an error.
//   Error message needs to be displayed when: 
//     - The title is empty - "Title is a mandatory field"
//     - The content is empty - "Content is a mandatory field"
//     - The title contains more than 10 characters - "Title cannot contain more than 10 characters"
//   Since this is a EditNote functionality, we need to make sure to display the 'Default Title' and 'Default Content'
//   when our component is rendered. 
class EditNoteForm extends Component {
        state = {
            title: '',
            content: '',
            titleErrorMessage: '',
            contentErrorMessage: ''
        }
  
    
    handleSubmit = (event) => {
        alert(`Title: ${this.state.title}\nContent: ${this.state.content}` );
        this.props.defaultTitle = this.state.title;
    }

    setTitle = (e) => {
        this.setState({title: e.target.value})
        if (this.state.title === '') {
            this.setState({titleErrorMessage: 'Title is a mandatory field!'});
        } else if (this.state.title.length > 10) {
            this.setState({titleErrorMessage: 'Title cannot contain more than 10 characters'});
        } else {
            this.setState({titleErrorMessage: ''});
        }
    }        

    setContent = (e) => {
        this.setState({content: e.target.value})
        if (this.state.content === '') {
            this.setState({contentErrorMessage: 'Content is a mandatory field!'});
        } else {
            this.setState({contentErrorMessage: ''});
        }
    }


    render() {
        return (
        <form onSubmit={this.handleSubmit}>
            <label>title</label> <input type="text" placeholder="Title" onChange={ this.setTitle } defaultValue={ this.props.defaultTitle } />
            <label>content</label> <input type="text" placeholder="Content" onChange={ this.setContent } defaultValue={ this.props.defaultContent }/>
            <input type="submit" value="Submit" disabled={this.state.title === '' || this.state.content === ''
            || this.state.title.length > 10 ? true : false}/>
            <hr/>
            <label> {this.state.titleErrorMessage} </label>
            <label> {this.state.contentErrorMessage} </label>
        </form>
        );
    }
}

export const Example = () => <EditNoteForm defaultTitle="Default title" defaultContent="Default Content" />;
