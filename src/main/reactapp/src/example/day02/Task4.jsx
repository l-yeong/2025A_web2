import { useState } from "react"

export default function Task4() {
    // 1. useState : 상태관리(변수값) 관리(변수값에따른재렌더링) 훅
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [age, setAge] = useState('');


    const [infoArray, setInfoArray] = useState([]); //회원정보 객체를 담는 리스트
    const infoAdd = () => {
        infoArray.push({ name, phone, age }); //입력받은 데이터 객체를 리스트에 저장
        setInfoArray([...infoArray]) // 리스트 재렌더링
    }
    
    const infoDelete=(phone)=>{
    // infoArray 배열에서, 전달받은 name과 일치하지 않는 항목만 남겨서 새로운 배열 생성
    // 즉, name이 같은 항목은 제외되어 삭제
        setInfoArray(infoArray.filter(info => info.phone != phone));
    }

    //=================================================== 내가 return 한것 ===================================================
    // return(<>
    //     <input value={name} onChange={(e)=>{setName(e.target.value)}} placeholder="성명"/>
    //     <input value={phone} onChange={(e)=>{setPhone(e.target.value)}} placeholder="연락처(예:010-1234-5678)"/>
    //     <input value={age} onChange={(e)=>{setAge(e.target.value)}} placeholder="나이"/>
    //     <ul>
    //         {infoArray.map((infos)=>{return <li>성명 : {infos.name} 연락처 : {infos.phone} 나이 : {infos.age}<button onClick={()=>infoDelete(infos.name)} >삭제</button></li>})}
    //     </ul>
    //     <button onClick={infoAdd}>등록</button>
    // </>)

    // ---------------------- [1] onClick={함수명}또는 2. onClick={()=>{}} 3. 주의할점 : onClick={함수명()}

    // ---------------------- [2] 리스트 출력시 forEach 대신에 **map** 사용한다 
    return (<>
        <input value={name} onChange={(e) => { setName(e.target.value) }} placeholder="성명" />
        <input value={phone} onChange={(e) => { setPhone(e.target.value) }} placeholder="연락처(예:010-1234-5678)" />
        <input value={age} onChange={(e) => { setAge(e.target.value) }} placeholder="나이" />
        <button onClick={infoAdd}>등록</button><br />
        {
            infoArray.map((i) => {
                return <div>성명 : {i.name} 연락처 : {i.phone} 나이 : {i.age}
                    <button onClick={()=>{infoDelete(i.phone)}}>삭제</button>
                </div>
            })
        }
    </>)
}//func end