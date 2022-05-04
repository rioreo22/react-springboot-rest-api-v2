import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {

const onSubmit = async (e) =>{
  console.log("test");
  e.preventDefault();
  e.persist();
  let images = e.target.clothes_file.files;
  console.log(images[0]);
  let formData = new FormData();

  axios.post('http://localhost:8080/api/v1/clothes',{

  })

}

  return (
    <div className="App">
      <form onSubmit={(e) => onSubmit(e)}>
        <div className="mb-3">
          <label htmlFor="formFile" className="form-label">Default file input example</label>
          <input className="form-control" type="file" id="formFile" name="clothes_file"/>
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
          <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
            <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default App;
