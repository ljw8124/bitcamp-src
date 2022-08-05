import React from 'react';
import PageTemplate from "../template/PageTemplate";
import MainComponent from "../Components/Main/MainComponent";
import HelloComponent from "../Components/Hello/HelloComponent";

const MainPage = () => {
    return (

        <PageTemplate>
            <MainComponent></MainComponent>
            <HelloComponent></HelloComponent>
        </PageTemplate>

    );
};

export default MainPage;