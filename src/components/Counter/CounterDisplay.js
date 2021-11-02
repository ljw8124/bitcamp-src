import React from 'react';
import {useSelector} from "react-redux";

const CounterDisplay = () => {

    const st = useSelector(state => state.countAsync)

    console.log(st) //전역상태로 받음

    return (
        <div>
            <h1>Count: {st.count}</h1>
        </div>
    );
};

export default CounterDisplay;