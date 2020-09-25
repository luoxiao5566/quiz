import React from 'react';
import imgURL from '../assets/avatar.jpg';
import '../style/style.css'

class Head extends React.Component {
  render() {
    return (
      <div>
        <img src={imgURL} alt="avatar" />
      </div>
    );
  }
}

export default Head;