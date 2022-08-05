import {createSlice} from "@reduxjs/toolkit";


const countSlice = createSlice({
    name: "countSlice",
    initialState: {count: 0},
    reducers: { //toolkit의 장점. immutable 한 객체이지만 변경이 가능해짐
        inc: state => {
            console.log("inc..........")
            state.count += 1
        },
        dec: state => {
            console.log("dec..........")
            state.count += -1
        }
    }
})

export const {inc, dec} = countSlice.actions

export default countSlice.reducer