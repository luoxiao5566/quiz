import React from 'react';
import './Home.css';
import ProductDetail from './ProductDetail';

class Home extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className='home'>
        {this.props.goods.map((item) => (
          <ProductDetail
            handleCart={this.handleCart}
            proName={item.proName}
            price={item.price}
            key={item.proName}
            imgURL={item.imgURL}
          />
         ))}
      </div>
    );
  }
}

export default Home;