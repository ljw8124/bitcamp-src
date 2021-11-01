import React, {useEffect, useState} from 'react';
import { useHistory } from "react-router-dom";
import * as queryString from "query-string";
import axios from "axios";

const pageInfoState = {
    count: 0,
    page: 1,
    size: 10,
    prev: false,
    next: false,
    start: 0,
    end: 0,
    dtoList: []
}

const range = (from, to) => {
    const arr = []
    for (let i = from; i <= to; i++) {
        arr.push(i)
    }
    return arr
}

const ListComponent = ({location}) => {

    const [pageInfo, setPageInfo] = useState(pageInfoState)

    const[reload, setReload] = useState(false)

    const history = useHistory() //window의 history를 의미하는 경우도 있음

    const params = queryString.parse(location.search)

    const pageDTO = {
        page : params.page || 1,
        size : params.size || 10
    }

    useEffect(() => {

        axios.get(`http://localhost:8080/api/board/list?page=${pageDTO.page}&size=${pageDTO.size}`)
            .then(resopnse => {
                console.log(resopnse.data)
                setPageInfo(resopnse.data) //ajax로 가져온 데이터로 pageInfo를 변경
            })

    },[pageDTO.page, reload])

    console.log(pageDTO)

    const dtoLi = pageInfo.dtoList.map(dto => <li key={dto.bno}>{dto.bno} --- {dto.title}</li>)

    const movePage = (pageNum) => {
        // alert("move " + pageNum)
        setReload(!reload)
        history.push(`/board/list?page=${pageNum}`)
    }


    const pageLi = range(pageInfo.start, pageInfo.end).map(pageNum =>
        <li key={pageNum} onClick={() => movePage(pageNum)}>{pageNum}</li>)

    return (
        <div>
            <h1>Board List Component</h1>
            <ul>
                {dtoLi}
            </ul>
            <ul>
                {pageLi}
            </ul>
        </div>
    );
};

export default ListComponent;