import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './styles.css';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import axios from 'axios';

export default class CreateNote extends Component {

    state = {
        title: '',
        content: '',
        tagsToAdd: [],
        tagNames: [],
        tags: []
    }

    componentDidMount() {
        axios.get('/api/tags')
        .then(res => {
            this.setState({ tags: res.data });
          })
    }

    setTitle = (e) => {
        this.setState({title: e.target.value})
    }

    setContent = (e) => {
        this.setState({ content: e.target.value })
    }

    handleSubmit = event => {

        const title = this.state.title;
        const content = this.state.content;
        const tags = this.state.tagsToAdd;

        axios.post('/api/notes', { title, content, tags })
        .then(response => console.log(response))
        .catch(error => console.log(error))
    }

    setTagsToAdd = (e) => {
        this.state.tagsToAdd.push(document.getElementById("selectId").value);
        var tagsNames = new Set();
        for(var i=0; i< this.state.tagsToAdd.length; i++) {
            for(var j=0; j< this.state.tags.length; j++) {
                if(this.state.tags[j].id == this.state.tagsToAdd[i]) {
                    tagsNames.add(this.state.tags[j])
                }
            }
        }
        this.setState({
            tagNames: [...tagsNames]
        })
    }

    render() {
        return <div  className="create-note">
         <form onSubmit={this.handleSubmit}> 
            <input type="text" placeholder="Title" onChange={ this.setTitle } className="create-note-title" />
            <textarea type="text" placeholder="Content" onChange={ this.setContent } className="create-note-content" />
            <input disabled={this.state.title === '' || this.state.content === '' ? true : false } type="submit" value="Create" className="create-note-button" />
            <br/>
        </form>
        <select id="selectId">
            { this.state.tags.map(tag => <option value={tag.id} key={tag.name}>{tag.name}</option>) }
        </select>
        <button onClick={this.setTagsToAdd}>Add tag</button>

        <br/>
            <div className="create-note-add-tags">
            { this.state.tagNames.map(tag => 
                <label className="create-note-add-tags-tag">
                    #{tag.name}  x
                </label>)
            }
            </div>
        </div>
        
    }
}


