import React, {Component} from 'react';
import {BrowserRouter as Router,Switch,Route, NavLink} from 'react-router-dom';
import './App.css';
import './style/style.css'

class App extends Component{
  render() {
    return (
      <Router>
        <ul className='head'>
            <li>
              <NavLink 
                className='links'                 
                to='/about-us'
                activeClassName = 'links1'
                >+添加商品</NavLink>
            </li>            
            <li>
              <NavLink
                className='links' 
                to='/my-profile'
                activeClassName = 'links1'
                >订单</NavLink>
            </li>            
            <li>
              <NavLink 
                className='links' 
                exact
                to='/'
                activeClassName = 'links1'
                >商城</NavLink>
            </li>
            
        </ul>
        <div className="app">
          <Switch>
                        
          </Switch>           
        </div>
      </Router>
    );
  }
}

export default App;
