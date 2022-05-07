import React, {useEffect, useState} from 'react';
import {ClothesCard} from "./ClothesCard";
import axios from "axios";
import {Summary} from "./Summary";

export function Clothes() {
    const [clothes, setClothes] = useState([]);

    const [items, setItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/clothes')
            .then(v => {
                setClothes(v.data);
            })

    }, [])

    const handleOrderSubmit = (order) => {
        if (items.length === 0) {
            alert("아이템을 추가해 주세요");
        } else {
            axios.post('http://localhost:8080/api/v1/orders', {
                email: order.email,
                address: order.address,
                postcode: order.postcode,
                orderItems:
                    items.map(v => ({
                        clothesId: v.id,
                        category: v.category,
                        price: v.price,
                        quantity: v.count
                    }))
            }).then(v => alert("주문이 정상적으로 접수 되었습니다."), e => {
                alert("장애");
                console.log(e)
            });
        }
        console.log(order, items);
    }

    const handleAddClicked = clothesId => {
        const product = clothes.find(v => v.id === clothesId);
        const found = items.find(v => v.id === clothesId);
        const updatedItems = found ? items.map(v => (v.id === clothesId) ? {
            ...v,
            count: v.count + 1
        } : v) : [...items, {...product, count: 1}]
        setItems(updatedItems);
        console.log(clothes.find(v => v.id === clothesId), "added!");
    }


    return (
        <div className="container">
            <div className="row">
                <div className="col-8">
                    <div className="row row-cols-4">
                        {clothes.map(v =>
                            <div key={v.id} className="col-3">
                                <ClothesCard {...v} onAddClick={handleAddClicked}/>
                            </div>
                        )}
                    </div>
                </div>
                <div className="col-4"><Summary className="col-3" items={items} onOrderSubmit={handleOrderSubmit}/>
                </div>
            </div>
        </div>
    );
}