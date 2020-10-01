import React from 'react';
import PropTypes from 'prop-types';
import './03-styling.css';
// import the css styles using: `import './03-styling.css'`
// this will use webpack to load the css styles into your app.


function Box(props) {
    return (
        // render a div with the props:
        // - className that is assigned to `Box Box--${props.size}`
        // - style that is assigned to props.style
        // inside the div, forward along props.children
        
    <div className={`Box Box--${props.size}`} style={props.style}>{props.size} {props.children}</div>
    );
}

// I'm gonna give this one to you. Isn't that nice? :)
Box.propTypes = {
    size: PropTypes.oneOf(['small', 'medium', 'large']),
    style: PropTypes.object,
    children: PropTypes.node.isRequired
};

const myStyles = {
    backgroundColor: 'teal'
}

export const Example = () => (
    <div>   
        <Box size="small" style={{backgroundColor: 'DodgerBlue'}}>box</Box>
        <Box size="medium" style={{backgroundColor: '#EF3E42'}}>box</Box>
        <Box size="large" style={{backgroundColor: '#A5ACAF'}}>box</Box>
    </div>
);
