import { useState } from "react"

export default function Task4(){

    const [name,setName]=useState('');
    const [phone,setPhone]=useState('');
    const [age,setAge]=useState('');

    
    const[infoArray,setInfoArray]=useState([]);
    const infoAdd=()=>{
        infoArray.push({name,phone,age});
        setInfoArray([...infoArray])
    }

    return(<>
        <input value={name} onChange={(e)=>{setName(e.target.value)}} placeholder="성명"/>
        <input value={phone} onChange={(e)=>{setPhone(e.target.value)}} placeholder="연락처(예:010-1234-5678)"/>
        <input value={age} onChange={(e)=>{setAge(e.target.value)}} placeholder="나이"/>
        <ul>
            {infoArray.map((infos)=>{return <li>성명 : {infos.name} 연락처 : {infos.phone} 나이 : {infos.age}<button >삭제</button></li>})}
        </ul>
        <button onClick={infoAdd}>등록</button>
    </>)
}//func end