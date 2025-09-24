import { useSelector } from "react-redux" //상태값 가져오기

export default function CartPage(props) {
    const cart = useSelector((state) => state.cart.items);
    return (<>
        <h3>카트페이지</h3>
        {cart.length === 0
            ?
            <p>장바구니 비어있음</p>
            :
            cart.map((m) => (
                <div>
                    {m.name}  {m.quantity}잔 = {(m.price*m.quantity).toLocaleString()}원
                </div>
            ))
        }


    </>)
}//func end