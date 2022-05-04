import React from 'react';
import { Link } from 'react-router-dom';

export function Header() {
    return (
        <div>
            <h1>헤더입니다.</h1>
            <Link to="/api/v1/clothes">옷 목록 보기</Link>
            <Link to="/api/v1/clothes/form">옷 등록 하기</Link>
        </div>
    );
}