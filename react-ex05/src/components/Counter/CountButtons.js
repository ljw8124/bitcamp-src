import React from 'react';
import {useDispatch} from "react-redux";
import {dec, inc} from "../../reducers/countSlice";
import {decAsync, incAsync} from "../../reducers/countSlice2";

const CountButtons = () => {

    const dispatch = useDispatch()

    return (
        <div>
            <button onClick={() => {dispatch(incAsync())} }>INC</button>
            <button onClick={() => {dispatch(decAsync())} }>DEC</button>
        </div>
    );
};

export default CountButtons;