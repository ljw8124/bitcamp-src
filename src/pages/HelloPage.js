import React from 'react';
import PageTemplate from "../template/PageTemplate";
import HelloComponent from "../Components/Hello/HelloComponent";

const HelloPage = () => {
    return (

        <PageTemplate>
            <HelloComponent></HelloComponent>
        </PageTemplate>

    );
};

export default HelloPage;