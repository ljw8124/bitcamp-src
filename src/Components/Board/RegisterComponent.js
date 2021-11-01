import React, {useState} from 'react';
import axios from "axios";
import {useHistory} from "react-router-dom";

const dtoState = {
    title:'샘플제목',
    content:'샘플내용',
    writer:'tester'
}

const RegisterComponent = () => {

    const [dto, setDTO] = useState({...dtoState}) //원본 데이터를 건드릴 수 없도록 ...으로 인스턴스화
    const history = useHistory()

    const changeDTO = (e) => {
        dto[e.target.name] = e.target.value
        setDTO({...dto})
    }

    const sendAjax = async () => {

        const response = axios.post("http://localhost:8080/api/board/register", dto)

        console.log(response.data)

        history.push("/board/list")

    }

    return (
        <>
            <div>
                <input type={'text'} name={'title'} value={dto.title} onChange={(e) => {changeDTO(e)}}/>
            </div>
            <div>
                <input type={'text'} name={'content'} value={dto.content} onChange={(e) => {changeDTO(e)}}/>
            </div>
            <div>
                <input type={'text'} name={'writer'} value={dto.writer} onChange={(e) => {changeDTO(e)}}/>
            </div>
            <div>
                <button type={'button'} onClick={() => sendAjax()}>REGISTER</button>
            </div>
        </>
    );
};

export default RegisterComponent;