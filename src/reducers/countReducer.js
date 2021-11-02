
const countInitState = {count:0}

export default (state = countInitState, action) => {
    console.log("reducer activate................." + action)

        const {type} = action

    if(type === 'INC'){
        return {count:state.count + 1}
    }else if(type === 'DEC'){
        return {count:state.count - 1}
    }

    return state
}