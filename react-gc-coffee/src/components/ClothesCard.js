import React from 'react';

export function ClothesCard(props) {

    const name = props.name;
    let imageurl = "http://localhost:8080/api/v1/clothes/image?imageName="+props.imagePath;
    return (
        <div className="card">
            <img className="card-img-top" src={imageurl} alt="Card image cap"/>
            <div className="card-body">
                <div className="row text-muted">{name}</div>
                <p className="card-text">{props.description}</p>
                <a href="/" className="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    );
}