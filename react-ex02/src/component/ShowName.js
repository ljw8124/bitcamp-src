import React, {useState} from 'react';

const ShowName = ({name, fn}) => { //구조분해할당 스타일

    //{}은 HTML에서 사용할 때. 전달받는 것은 그냥 사용
    //const fn = props.fn

    const [num, setNum] = useState(10) //Hooks 적용

    //함수호출
    fn()

    //viewModel의 특징 -> 모니터링 할 존재가 필요함. 변경 시 변경에 반응하고 다시 출력할 존재. => Hook
    const changeNum = () => {
        alert("ChangeNum...........")
        setNum(100)
    }

    return (
        <div>
            <h1>{name}</h1>
            <h2>{num}</h2>
            <button onClick={() => changeNum()}>CHANGE</button>
        </div>
    );
};

export default ShowName;