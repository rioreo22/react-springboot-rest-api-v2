import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import React from 'react';
import axios from 'axios';
import {ClothesForm} from "./components/ClothesForm";

function App() {
    return (
        <div className="App">
            <ClothesForm/>
        </div>
    );
}

export default App;
