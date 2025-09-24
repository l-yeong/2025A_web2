import { Link,useNavigate } from "react-router-dom";

//store 저장된 상태를 가져오기

export default function Header(props){
    return(<>
        <h3>헤더 페이지</h3>
        <ul>
        <li><Link to ="/">홈</Link></li>
        <li><Link to ="/menu">메뉴</Link></li>
        <li><Link to ="/cart">장바구니</Link></li>
        </ul>
    </>)
}//func end