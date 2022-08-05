import {useState} from "react";

//reset 버튼을 위해서 존재
const initState = []

export default () => {

    const [cart, setCart] = useState(initState)

    const addProduct = (product) => {

        //중복된 상품 검사
        const before = cart.filter(item => item.pno === product.pno)[0]

        if(before) {
            before.qty = before.qty + 1
            setCart([...cart])
            return
        }
        setCart([...cart, {...product, qty:1}]) //처음 추가한다면 qty를 1로 설정하여 cart 설정
    }

    const resetCart = () => {
        setCart(initState)
    }

    const removeProduct = (pno) => {
        // console.log("removeProduct: " + pno)

        const idx = cart.findIndex(item => item.pno === pno)
        // console.log("idx : " + idx)

        //수량이 0일 경우
        if(idx > -1) {
            cart.splice(idx,1)
            setCart([...cart])
        }
    }

    const getTotal = () => {
        let sum = 0

        for(let i = 0; i < cart.length; i++) {

            const item = cart[i]
            sum += item.price * item.qty
        }
        return sum
    }

    const changeQty = (pno, amount) => {
        const target = cart.filter(item => item.pno === pno)[0]

        if(target) {

            target.qty = target.qty + amount
            if(target.qty <= 0) {
                removeProduct(pno)
                return
            }
        }
        setCart([...cart])
    }

    return(
        {cart, addProduct, resetCart, removeProduct, getTotal, changeQty}
    )
}