import React from 'react';
import './styles.css';
import {Link} from 'react-router-dom';

export default function Header(props) {
    return <header className="notes-header">
        <div className="header-title">
           
            <Link to="/" className="ahref">
                {props.title}
            </Link>
        
            <Link to="/manage-tags">
                <button className="header-button">Manage tags</button>
            </Link>

        </div>
    </header>
}