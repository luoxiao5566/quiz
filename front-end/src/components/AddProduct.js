import React, { Component } from "react";
import "./AddProduct.css";

class AddProduct extends Component {
  state = {
    proName: '',
    price: '',
    unit: '',
    imgURL: '',
  }
  
  handleChange = (event) => {
        event.preventDefault();
        this.setState({ [event.target.name]: event.target.value });
  };
  handleSubmit= async (event) => {
    event.preventDefault();
    try {
        const data = await fetch("http://localhost:8080/pd/addPro",{
          method:"POST",
          body:JSON.stringify({
            proName: this.state.proName,
            price: this.state.price,
            unit: this.state.unit,
            imgURL: this.state.imgURL,
          }),
          headers: {
              'Content-Type': 'application/json'
          }
        });
        const result = await data.json();
        console.log(JSON.stringify(result));        
      } catch (err) {
        console.log(err);
      }
    console.log(JSON.stringify(this.state));    
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          * 名称:<br />
          <input type="text" name="proName" onChange={this.handleChange} value={this.state.proName} placeholder='货品名称' className='input' />
        </label><br />
        <label>
        * 价格:<br />
          <input type="text" name="price" onChange={this.handleChange} value={this.state.price} placeholder='价格' className='input' />
        </label><br />
        <label>
          * 单位:<br />
          <input type="text" name="unit" onChange={this.handleChange} value={this.state.unit} placeholder='单位' className='input' />
        </label><br />
        <label>
          * 图片:<br />
          <input type="text" name="imgURL" onChange={this.handleChange} value={this.state.imgURL} placeholder='图片' className='input' />
        </label>
        <br />
        <input type='submit' value='Submit' disabled={!this.state.proName || !this.state.price || !this.state.unit || !this.state.imgURL} />
      </form>
    );
  }
}

export default AddProduct;
