import { useDispatch } from "react-redux"
import {menu} from '../store/cartslice.jsx'
import { useNavigate } from "react-router-dom";

export default function MenuPage(props){
    // 액변 하기 위한 dispatch 함수 가져오기
    const dispatch = useDispatch();

    // 가상URL로 페이지 전환하기 위한 navigate 함수 가져오기
    const navigate = useNavigate();

    const menuInfo = [
    { id: 1, name: "아메리카노", price: 3000 }, 
    { id: 2, name: "카페라떼", price: 4000 },
    { id: 3, name: "카푸치노", price: 4500 },
];

    const onMenu =async(item)=>{
        alert("추가되었습니다");
        dispatch(menu(item)); //전역변수 상태변경
        navigate("/cart");  // 페이지 전환
    }
    return(<>
    <h3>메뉴페이지</h3>
    {menuInfo.map(m=>(
        <div>{m.name} - {m.price}원 <button onClick={()=>onMenu(m)}>추가</button></div> 
    ))}
    
    </>)
}//func end