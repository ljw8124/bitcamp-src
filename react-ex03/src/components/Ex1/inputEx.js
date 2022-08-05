import React, {useState} from 'react';

const initData = {
    title:'',
    content:'',
    writer:''
}

const InputEx = () => {

    const [data, setData] = useState({...initData}) //react는 state를 이용하여 계속해서 갱신해야함

    const handleChange = (e) => {
        const target = e.target

        const targetName = target.name
        // console.log("--------------------------------")
        // console.log(target)
        // console.log(targetName)
        // console.log("================================")

        data[targetName] = target.value
        //console.log("change")
        setData({...data})
    }

    const handleClaer = (e) => {
        setData({...initData})
    }

    return (

       <div>
           <h3>{data.title} ---- {data.content}</h3>
           <h1>INPUT</h1>
           <input type='text' name='title' value={data.title} onChange={(e) => {handleChange(e)}}/>
           <input type='text' name='content' value={data.content} onChange={(e) => {handleChange(e)}}/>
           <button onClick={(e) => {handleClaer(e)}}>CLEAR</button>
       </div>

    );
};

export default InputEx;