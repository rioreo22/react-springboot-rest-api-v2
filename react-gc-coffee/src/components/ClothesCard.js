import React from 'react';

export function ClothesCard(props) {
    const name = props.name;
    const imageurl = "http://localhost:8080/api/v1/clothes/image?imageName=" + props.imagePath;

    const handleAddBtnClicked = e => {
        props.onAddClick(props.id);
    };

    return (
        <div className="card">
            <img className="card-img-top" src={imageurl} alt="Card image cap"/>
            <div className="card-body">
                <div className="row"><h3>{name}</h3></div>
                <div className="row"><h5>{props.category}</h5></div>
                <p className="card-text">{props.description}</p>
                <p className="card-text">{props.price} 원</p>
                <button onClick={handleAddBtnClicked} href="/" className="btn btn-primary">장바구니에 담기</button>
            </div>
        </div>
    );
}