import React from 'react';
import {Link} from "react-router-dom";

//Sidebar Component로 쪼개놓음
const Sidebar = () => {
    return (
        <div className="border-end bg-white" id="sidebar-wrapper">
            <div className="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
            <div className="list-group list-group-flush">
                <Link className="list-group-item list-group-item-action list-group-item-light p-3" to="/hello">Hello</Link>
                <Link className="list-group-item list-group-item-action list-group-item-light p-3" to="/main">Main</Link>
                <Link className="list-group-item list-group-item-action list-group-item-light p-3" to="/portfoilo">Portfoilo</Link>
                <Link className="list-group-item list-group-item-action list-group-item-light p-3" to="/board/list">Board</Link>
                <a className="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                <a className="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
            </div>
        </div>
    );
};

export default Sidebar;