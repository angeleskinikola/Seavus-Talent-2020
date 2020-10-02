import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './04-composition.css';
import axios from 'axios';

// For our data fetching exercise we're gonna take advantage of the Notes REST API that you already created.
//
// It is best to use lifecycle method `componentDidMount` to
// make AJAX requests. This method will be called once before the component
// is inserted into the document, regardless of how many times `render` is
// called.
//
// Exercise:
//
//  Create a NotesGrid component that lists all the notes from http://localhost:8080/api/notes.
//  This component needs to display all the notes in a grid with their info as "title", "content", "tags".
//



export default class NotesGrid extends Component {

    state = {
        notes: []
    }

    componentDidMount() {
        axios.get('/api/notes')
            .then(response => {
                const notes = response.data;
                this.setState({ notes })
            })
    }

    render() {
        return (
            <div>
                { this.state.notes.map(note => <Note title={note.title} content={note.content} tags={note.tags}/>) }
            </div>
        );
    }

}

function Note(props) {

    return <div className="note">
        <NoteHeader title={props.title}/>
        <NoteContent content={props.content}/>
        <NoteFooter tags={props.tags}/>
    </div>;
}

Note.propTypes = {
    title: PropTypes.string.isRequired,
    content: PropTypes.string.isRequired
};

function NoteHeader({ title }) {
    return (
        <div className="note-header">
            {title}
        </div>
    );
}

NoteHeader.propTypes = {
    title: PropTypes.string.isRequired
};

function NoteContent({ content }) {
    return (
        <div className="note-content">
            {content}
        </div>
    );
}

NoteContent.propTypes = {
    content: PropTypes.string.isRequired
};
function NoteFooter({ tags }) {
    return (
        <div className="note-footer">
            { tags.map(tag => <label>#{tag.name} </label>) }
        </div>
    );
}

NoteFooter.propTypes = {
    onEdit: PropTypes.func.isRequired
};

export const Example = () => <NotesGrid />;
