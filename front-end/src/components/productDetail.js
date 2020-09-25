import React from 'react';
import '../style/style.css'
// import imgURL from '../picture/kele.jpg'


const ProductDetail = ({imgURL,name,price,id}) => (
    <div className='pro'>        
        <img src={imgURL} alt='product' />    
        <p>Name:{name}</p>
        <p>Price:{price}</p>
        <p>Id:{id}</p>
    </div>
);

export default ProductDetail;