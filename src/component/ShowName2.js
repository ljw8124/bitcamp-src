import React, {useState} from 'react';

const ShowName = ({name, num}) => {

    console.log("show name...............")

    return (
        <div>
            <h1>{name}</h1>
            <h2>{num}</h2>
        </div>
    );
};

export default ShowName;