import {createStore} from "redux";
import countReducer from "../reducers/countReducer";
import {configureStore} from "@reduxjs/toolkit";
import countSlice from "../reducers/countSlice";
import countSlice2 from "../reducers/countSlice2";


export default configureStore({
    reducer: {
        countReducer: countSlice,
        countAsync: countSlice2
    }
})