import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './styles.css';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import axios from 'axios';

export class UpdateNote extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            title: '',
            content: '',
            tags: []
        }
    }
    
    componentDidMount() {
        if(this.state.id) {
            this.findNoteById(this.state.id);
        }
    }

    findNoteById = (noteId) => {
        axios.get('/api/notes/'+noteId)
        .then(res => {
            const data = res.data
            this.setState({
                title: data.title,
                content: data.content,
                tags: data.tags

            })
        })
        .catch(err => console.log(err))
    }

    setTitle = (e) => {
        this.setState({title: e.target.value})
    }

    setContent = (e) => {
        this.setState({ content: e.target.value })
    }

    handleSubmit = event => {
        const id = this.state.id;
        const note = {
            title: this.state.title,
            content: this.state.content,
            tags: this.state.tags.map(tag => tag.id)
        }
        // const tags = this.state.tagsToAdd;

        axios.put(`/api/notes/${id}`, note)
        .then(response => console.log(response))
        .catch(error => console.log(error))
    }


    render() {
        return(<div className="update-note">
            <form onSubmit={this.handleSubmit} >
                <input type="text" onChange={this.setTitle} defaultValue={this.state.title} className="update-note-title" />
                <br/>
                <textarea type="text" onChange={this.setContent} defaultValue={this.state.content} className="update-note-content" />
                <input disabled={this.state.title === '' || this.state.content === '' ? true : false} type="submit" value="Update" />                
            </form>
            <label>Tags: </label>
            <select id="selectTagIdUpdate">
                { this.state.tags.map(tag => <option value={tag.id}>{tag.name}</option>) }
            </select>
            </div>           
       );
    }    
}

export default UpdateNote;