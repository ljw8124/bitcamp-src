import React from 'react';
import ShowName from "./ShowName";

const HelloWorld = () => {
    //jsx라고함 -> 기본적으로 react의 component는 하나의 태그를 이야기함. 묶음 처리 필요

    let num = 10

    //display는 변수 -> 밑에서 {}으로 감싼이유
    const display = () => {
        console.log("display")

    }

    return (
        <div>
            <h1>Hello World!!!</h1>
            <ShowName name="홍길동" fn = {display}></ShowName>
        </div>
    );
};

export default HelloWorld; //함수자체를 리턴하기 위해서 ()가 없음