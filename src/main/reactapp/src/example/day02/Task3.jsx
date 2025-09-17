import { useState } from "react";

export default function Task3(props){

    //[1]제품명
    //1-1선언
    const [product,setProduct]=useState('');
    const productAdd=(e)=>{
        // 2-2 입력받은 제품명 변경 함수, e : onChange를 이벤트결과 정보 담긴 객체
        setProduct(e.target.value);
        console.log(e.target.value);
    }

    //[2] 수량 관리하는 useState, const[변수명,set변수명] =useState(초기값);
    // 2-1.선언
    const [count,setCount]=useState(0);
    // 2-2. 수정: 증가
    function stockPlus(){const plusCount = count+1;setCount(plusCount);}
    // 2-2. 수정: 감소
    const stockMinus=()=>{const minusCount = count-1;setCount(minusCount);}

    return(<>
        <h1>Task3</h1>
        <div>제품명:<input value={product} onChange={productAdd}/></div>
        {/*
        함수 사용 안하고 바로 적용 하는법
        <div>제품명:<input value={product} onChange={(e)=>{setProduct(e.target.value)}}/></div>
         */}
        현재 수량:{count}
        <br/>
        <button onClick={stockMinus}>감소</button> <button onClick={stockPlus}>증가</button>
        </>)
}//func end