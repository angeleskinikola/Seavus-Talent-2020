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
            tags: [],
            allTags: []
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
        axios.get('/api/tags')
            .then(res => {
                const data1 = res.data
                this.setState({
                    allTags: data1
                })
            }) .catch(err => console.log(err))
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

    setTagsToAdd = (e) => {
        var tagsNames = new Set();
        
        for(var i=0; i< this.state.allTags.length; i++) {
            var count = 0;
            for(var j=0; j < this.state.tags.length; j++) {
                if(this.state.allTags[i] == this.state.tags[j]) {
                    count++;
                } 
            }
            if(count === 0 && document.getElementById("selectIdNewTag").value == this.state.allTags[i].id) {
                tagsNames.add(this.state.allTags[i])
            } 
        }
        this.setState({
            tags: [...this.state.tags, ...tagsNames]
        })
    }

    render() {
        return(<div className="update-note">
                    <form onSubmit={this.handleSubmit} >
                        <input type="text" onChange={this.setTitle} defaultValue={this.state.title} className="update-note-title" />
                        <br/>
                        <textarea type="text" onChange={this.setContent} defaultValue={this.state.content} className="update-note-content" />
                        <input disabled={this.state.title === '' || this.state.content === '' ? true : false} type="submit" value="Update" />                
                    </form>
                    <select id="selectIdNewTag">
                        { this.state.allTags.map(tag => <option value={tag.id} key={tag.name}>{tag.name}</option>) }
                    </select>
                    <button onClick={this.setTagsToAdd}>Add tag</button>

                    <div className="update-note-tags">
                        { this.state.tags.map(tag => <button className="selectTagIdUpdate">#{tag.name}</button>) }
                    </div>
                </div>           
       );
    }    
}

export default UpdateNote;
