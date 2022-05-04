import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React from 'react';
import axios from 'axios';
import {Header} from "./components/Header";
import {ClothesForm} from "./components/ClothesForm";
import {Clothes} from "./components/Clothes";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path={"/api/v1/clothes/form"} element={<ClothesForm/>}></Route>
                    <Route path={"/api/v1/clothes"} element={<Clothes/>}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
