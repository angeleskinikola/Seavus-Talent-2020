import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './styles.css';
import {BrowserRouter as Router, Route, Switch, Link} from 'react-router-dom';
import axios from 'axios';
import {Note} from './Note'

export default class FilterNotesByTag extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            notes: []
        }
    }

    componentDidMount() {
        axios.get(`/api/tags/${this.state.id}/notes`)
            .then(res => {
                const data = res.data;
                this.setState({notes: data})
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