import React, {useEffect, useState} from 'react';
import axios from "axios";

const pageState = 1

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

const BoardList = () => {

    const [page, setPage] = useState(pageState)
    const [pageInfo, setPageInfo] = useState(pageInfoState)
    const [reload, setReload] = useState(false)

    useEffect(() => { //가장 중요하게 쓰이는 메서드
        console.log("userEffect + " + page)

        //Spring Boot와 연결
        axios.get(`http://localhost:8080/api/board/list?page=${page}`)
            .then(response => {
                const data = response.data
                console.log(data)
                setPageInfo(data)
            })

    }, [reload])

    const liList = pageInfo.dtoList.map(dto => <li key={dto.bno}>{dto.bno} -- {dto.title}</li>)

    const pageNumList = range(pageInfo.start, pageInfo.end).map(pageNum => <li key={pageNum} onClick={() => {
        setPage(pageNum)
        setReload(!reload)
    }}>
        {pageNum}</li>)

    return (
        <div>
            <button onClick={() => {
                setPage(page + 1)
            }}>to the Next!!!
            </button>

            <ul>
                {liList}
            </ul>

            <ul>
                {pageInfo.prev ? <li onClick={() => {
                    setPage(pageInfo.start - 1)
                    setReload(!reload)
                }}>이전</li> : ''}
                {pageNumList}
                {pageInfo.next ? <li onClick={() => {
                    setPage(pageInfo.end + 1)
                    setReload(!reload)
                }}>다음</li> : ''}
            </ul>

        </div>
    );
};

export default BoardList;