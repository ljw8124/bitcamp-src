import React from 'react';

const ProductDisplay = ({products, addCart}) => { //props

    const list = products.map(p => <li key={p.pno} onClick={() => addCart(p)}>{p.pname} --- {p.price}원</li>) //loop를 돌릴때는 key가 있어야 함

    return (
        <div>

            <h1>상품목록</h1>

            <div className="card col-6">
                <div className="card-header">
                    This is some text within a card header.
                </div>
                <div className="card-body">
                    This is some text within a card body.
                </div>
                <div className="card-footer">
                    This is some text within a card footer.
                </div>
            </div>

            <ul>
                {list}
            </ul>
        </div>
    );
};

export default ProductDisplay;