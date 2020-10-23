import React from 'react';
import './ProductDetail.css';

class productDetail extends React.Component {
    constructor(props) {
      super(props);
    }
    render() {
        return (
          <div className="good">
            <img className="phoneImg" src={this.props.imgURL} />
            <div>{this.props.proName}</div>
            <div className='price'>单价：</div>
            <p className='price'>{this.props.price}</p> <div className='price'>元/瓶</div>
            <button onClick={this.props.handleCart}>+</button>
          </div>
        );
      }
    }

export default productDetail;