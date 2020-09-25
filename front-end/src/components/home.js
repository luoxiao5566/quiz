import React from 'react';
import '../style/style.css';
import ProductDetail from './productDetail';
import imgURL from '../picture/kele.jpg'


class Home extends React.Component {
    state = {
        url:imgURL,
        name:'kele',
        price: '3元/瓶',
        id:1
    }

  render() {
    return (
      <div className='home'>
        <h1>asdasdsad</h1>
        <ProductDetail
            imgURL={this.state.url}
            name={this.state.name}
            price={this.state.price}
            id={this.state.id}
         />
      </div>
    );
  }
}

export default Home;