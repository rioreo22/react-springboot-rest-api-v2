import React from 'react';

export function CategorySelect(props) {
    return (
        <div className="mb-3">
            <label> Category</label>
            <select className="form-select" id="category" name="category">
                    {props.categories.map((category) => (
                        <option
                            key={category}
                            value={category}
                        >
                            {category}
                        </option>
                    ))}
            </select>
        </div>
    );
}