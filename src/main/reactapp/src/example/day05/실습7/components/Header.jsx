import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { logout } from "../store/userSlice";


export default function Header(props) {
    //store 저장된 상태 가져오기
    // const { isAuthenticated } = useSelector((state) => state.user);
    const {isAuthenticated, userInfo} = useSelector((state)=>state.user);
    //액션(상태변경) 하기 위한 dispatch 함수 가져오기
    const dispatch = useDispatch();

    //가상 URL로 페이지 전환하기 위한 useNavigate 함수 가져오기
    const navigate = useNavigate();

    //로그아웃 처리
    const onLogout = async () => {
        alert('[로그아웃 성공]');
        dispatch(logout()); // 상태가 변경되면 **리렌더링**된다.
        navigate("/");
    }

    // 서버에게 로그인 상태 요청 useEffect(()=>{})

    return (<>
        {isAuthenticated == true
            ?
            <div>
                <h3>안녕하세요 {userInfo.name}님 </h3>
                <ul>
                    <li><button onClick={onLogout}>로그아웃</button></li>
                    <li><Link to="/profile">프로필</Link></li>
                </ul>
            </div>
            :
            <div>
                <h3>로그인 페이지</h3>
                <ul>
                    <li><Link to="/login">로그인</Link></li>
                </ul>
            </div>
        }
    </>)
}//func end