import React, {useEffect, useState} from 'react';
import {ClothesCard} from "./ClothesCard";
import axios from "axios";

export function Clothes() {
    const [clothes, setClothes] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/clothes')
            .then(v => setClothes(v.data))
    }, [])

    return (
        <div className="container">
            <div className="row">
                {clothes.map(v =>
                    <div key={v.id} className="col-4">
                        <ClothesCard {...v}/>
                    </div>
                )}
            </div>
        </div>
    );
}