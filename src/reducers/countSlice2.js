import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";

export const incAsync = createAsyncThunk('counterInc', async (num) => {

    console.log("inc")

    await axios.get("http://localhost:8080/api/delay")

    return 1
})

export const decAsync = createAsyncThunk('counterDec', async (num) => {

    console.log("dec")

    await axios.get("http://localhost:8080/api/delay")

    return -1
})

const countSlice2 = createSlice({
    name:"counter",
    initialState: {count:0},
    reducers: {

    },
    extraReducers: {
        [incAsync.fulfilled]: (state, {payload}) => {

            console.log("inc:"+payload)

            return {count:state.count + payload}
        },
        [decAsync.fulfilled]: (state, {payload}) => {

            console.log("dec:"+payload)

            return {count:state.count + payload}
        },
    }
})

export default countSlice2.reducer

