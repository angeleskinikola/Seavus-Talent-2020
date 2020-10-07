import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './styles.css';
import axios from 'axios';
import {Route, useHistory, Link} from 'react-router-dom'
import UpdateNote from './UpdateNote';

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
            <div className="notes-grid">
               { this.state.notes.map(note => <Note id={note.id} title={note.title} content={note.content} tags={note.tags}/>) }
            </div>
        );
    }

}

export function Note(props) {

    return <div className="note">
        <NoteHeader title={props.title} id={props.id}/>
        <NoteContent content={props.content}/>
        <NoteFooter title={props.title} content={props.content} id={props.id} tags={props.tags}/>
    </div>;
}

Note.propTypes = {
    title: PropTypes.string.isRequired,
    content: PropTypes.string.isRequired
};

function NoteHeader({ title, id }) {
    const deleteNote = event => {
        axios.delete(`/api/notes/${id}`)
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }
    return (
        <form onSubmit={deleteNote} className="note-header">
            {title}
            <input type="submit" className="note-header-button" value="X"/>
        </form>
    );
}

// function deleteNote(id) {
//     axios.delete(`/api/notes/${id}`)
//         .then(res => console.log(res))
//         .catch(error => console.log(error))
// }

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
function NoteFooter({ title, content, id, tags }) {
    return (
        <div className="note-footer">
            { tags.map(tag => <Link to={"/tags/"+tag.id+"/notes"}> <button className="footer-tag-button">#{tag.name} </button> </Link>) }
            <Link to={"/update-note/" + id} >
            <button className="note-footer-button">Edit</button>
            </Link> 
        </div>
    );
}

NoteFooter.propTypes = {
    onEdit: PropTypes.func.isRequired
};

export const Example = () => <NotesGrid />;