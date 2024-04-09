import React from 'react';
import '../css/header.scss'

export default function Header() {

    const today = new Date();
    const formattedDate = today.toLocaleDateString();

    return (
        <div className="Header">
            <div className="todayblock">
                <span>{formattedDate}</span>
            </div>
        </div>
    )
}