import React from 'react';
import ShowName from "./ShowName";
import Dice from "./Dice";
import CountContainer from "./counter/CountContainer";
import KioskContainer from "./kiosk/KioskContainer";

const HelloWorld = () => {
    //jsx라고함 -> 기본적으로 react의 component는 하나의 태그를 이야기함. 묶음 처리 필요

    let num = 10

    //display는 변수 -> 밑에서 {}으로 감싼이유 -> JavaScript는 함수지만 변수처럼 사용가능
    const display = () => {
        console.log("display")

    }

    return (
        <>
            <KioskContainer></KioskContainer>
        </>
    );
};

export default HelloWorld; //함수자체를 리턴하기 위해서 ()가 없음

