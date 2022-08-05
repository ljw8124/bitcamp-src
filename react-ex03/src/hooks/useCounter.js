import {useState} from "react";

//custom hooks
export default () => {

    const [num, setNum] = useState(0)

    const change = (amount) => {
        setNum(num + amount)
    }

    return(
        {num, change}
    )
}