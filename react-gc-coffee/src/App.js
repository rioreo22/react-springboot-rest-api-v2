import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import React from 'react';
import {Header} from "./components/Header";
import {ClothesForm} from "./components/ClothesForm";
import {Clothes} from "./components/Clothes";

function App() {

    return (
        <div className="App">
            <BrowserRouter>
                <div className="row justify-content-center m-4">
                    <h1 className="text-center">Grids & Circle</h1>
                    <Header/>
                </div>
                <Routes>
                    <Route path={"/api/v1/clothes/form"} element={<ClothesForm/>}></Route>
                    <Route path={"/api/v1/clothes"} element={<Clothes/>}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
