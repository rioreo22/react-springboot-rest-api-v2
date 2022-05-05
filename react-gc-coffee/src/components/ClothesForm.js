import React from 'react';
import axios from "axios";

export function ClothesForm() {
    const onSubmit = async (e) => {
        e.preventDefault();
        e.persist();

        let formData = new FormData();
        formData.append("image", e.target.clothes_file.files[0]);
        formData.append("name", e.target.name.value);
        formData.append("category", e.target.category.value);
        formData.append("description", e.target.description.value);
        formData.append("price", e.target.price.value);

        await axios({
            method: "POST",
            url: `http://localhost:8080/api/v1/clothes`,
            mode: "cors",
            headers: {
                "Content-Type": "multipart/form-data",
            },
            data: formData,
        });

    }

    return (
        <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
                <label className="form-label">Clothes Image</label>
                <input className="form-control" type="file" id="formFile" name="clothes_file"/>
            </div>
            <div className="mb-3">
                <label className="form-label">Name</label>
                <input type="text" className="form-control" id="name" name="name"/>
            </div>
            <div className="mb-3">
                <label className="form-label">Price</label>
                <input type="text" className="form-control" id="price" name="price"/>
            </div>
            <div className="mb-3">
                <label className="form-label">Description</label>
                <input type="text" className="form-control" id="description" name="description"/>
            </div>
            <div className="mb-3">
                <label> Category</label>
                <select className="form-select" id="category" name="category">
                    <option value="TOP">TOP</option>
                    <option value="BOTTOM">BOTTOM</option>
                    <option value="SOCKS">SOCKS</option>
                </select>
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
        </form>
    );
}