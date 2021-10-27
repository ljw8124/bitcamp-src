import React from 'react';
import styles from '../../App.css';

const CartDisplay = ({cart, remove, getTotal, change}) => {

    const list = cart.map((item, idx) => <li key={idx}>{item.pname} --- {item.price} -----
        <button onClick={() => change(item.pno, -1)}>-</button>{item.qty}<button onClick={() => change(item.pno, 1)}>+</button>

        <button onClick={() => remove(item.pno)}>X</button>

    </li>)

    return (
        <div className={styles.ulStyle}>
            <h1>장바구니</h1>
            <ul>
                {list}
            </ul>
            <h3>{getTotal()}</h3>
        </div>
    );
};

export default CartDisplay;