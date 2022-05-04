import React from 'react';

export function ClothesCard(props) {

    const name = props.name;

    return (
        <div className="card">
            <img className="card-img-top" src={props.image} alt="Card image cap"/>
            <div className="card-body">
                <div className="row text-muted">{name}</div>
                <p className="card-text">{props.description}</p>
                <a href="/" className="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    );
}