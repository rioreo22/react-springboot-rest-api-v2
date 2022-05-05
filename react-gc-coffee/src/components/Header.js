import React from 'react';
import { Link } from 'react-router-dom';

export function Header() {
    return (
        <div>
            <nav className="nav nav-pills flex-column flex-sm-row">
                <Link className="flex-sm-fill text-sm-center nav-link" aria-current="page" to="/api/v1/clothes">옷 목록 보기</Link>
                <Link className="flex-sm-fill text-sm-center nav-link" aria-current="page" to="/api/v1/clothes/form">옷 등록 하기</Link>
            </nav>
        </div>
    );
}