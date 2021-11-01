import React from 'react';
import PageTemplate from "../../template/PageTemplate";
import ListComponent from "../../Components/Board/ListComponent";

//React Router로 쓰면 location 받아올 수 있음
const BoardListPage = ({location}) => {

    return (
            <PageTemplate>
                <ListComponent location={location}></ListComponent>
            </PageTemplate>
    );
};

export default BoardListPage;
