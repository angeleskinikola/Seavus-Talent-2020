import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './styles.css';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import axios from 'axios';

export default class ManageTags extends Component {

    state = {
        name: '',
        tags: []
    }

    componentDidMount() {
        axios.get('/api/tags')
            .then(response => {
                const tags = response.data;
                this.setState({ tags })
            })
    }

    setName = (e) => {
        this.setState({name: e.target.value})
    }

    handleSubmit = event => {

        const name = this.state.name;

        axios.post('/api/tags', { name })
        .then(response => console.log(response))
        .catch(error => console.log(error))
    }

    handleSubmitDelete = event => {
        const id = document.getElementById("selectTagId").value;
        axios.delete(`/api/tags/${id}`)
    }

    render() {
        return (<div className="tags-grid">
            <form onSubmit={this.handleSubmit} > 
                <input placeholder="Create new tag" className="tags-name" onChange={ this.setName }/> 
                <input disabled={this.state.name === '' ? true : false } type="submit" value="Create" />
                <br/>
            </form>
            <br/>
            <select id="selectTagId">
                { this.state.tags.map(tag => <option value={tag.id}>{tag.name}</option>) }
            </select>
            <form onSubmit={this.handleSubmitDelete} className="delete-tag-button">
                <input type="submit" value="Delete" />
            </form>            
            </div>
        );
    }
}


