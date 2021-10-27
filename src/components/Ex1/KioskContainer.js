import React, {useState} from 'react';
import ProductDisplay from "./ProductDisplay";
import CartDisplay from "./CartDisplay";
import useCart from "../../hooks/useCart";

const products = [
    {pno:1, pname:'샤프', price:3000},
    {pno:2, pname:'공책', price:1000},
    {pno:3, pname:'지우개', price:700},
    {pno:4, pname:'샤프심', price:500},
    {pno:5, pname:'실내화', price:6000}
]

const cart = []

const KioskContainer = () => {

    const {cart, addProduct, resetCart, removeProduct, getTotal, changeQty} = useCart()

    return (
        <div>
            <ProductDisplay products={products} addCart={addProduct}></ProductDisplay>
            <CartDisplay cart={cart} remove={removeProduct} getTotal={getTotal} change={changeQty}></CartDisplay>
            <button onClick={() => (resetCart())}>RESET</button>
        </div>
    );
};

export default KioskContainer;