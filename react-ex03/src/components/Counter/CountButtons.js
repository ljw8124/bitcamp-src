import React from 'react';

const CountButtons = ({change}) => { //props로 받기

    // const {change} = useCounter()

    return (
        <div>
            <button onClick={() => change(1)}>INC</button>
            <button onClick={() => change(-1)}>DEC</button>
        </div>
    );
};

export default CountButtons;