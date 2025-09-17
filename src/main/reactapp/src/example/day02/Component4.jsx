
export default function Component4(props){

    //JS구역
    const obj={name:"유재석",age:"40"};



    return(<>
        {/* JSX 구역 */}
        <h3>Component4</h3>
        <h3>{obj.name},{obj.age}</h3>
        <SubComp key1="value1" key2="value2"/>
        <SubComp name="유재석" 나이="40"/>
        <SubComp name={obj.name} age={obj.age} />
        </>)

}//func end

function SubComp(props){
    console.log("Sub",props);
    return(<>
        <h4>Sub 컴포넌트</h4>
        <SubSubComp key3="value"/>
        </>)
}//func end

let count2 = 0; //함수 밖에 있는 변수
function SubSubComp(props){
    console.log("SubSub",props);
    let count=0; // 지역변수 특성 : *현재실행중인* 함수(컴포넌트) 안에서 사용되는 변수
    const onAdd=()=>{
        count++; console.log(`지역변수: ${count}`)
        count2++; console.log(`전역변수: ${count2}`)
    }
    return(<>
        <h6>SubSub 컴포넌트</h6>
        {/* JSX 에서는 onclick 대신에 onClick 속성으로 사용한다. */}
        <button onClick={onAdd}>버튼</button>
        <h6>지역변수 count : {count} / 전역변수 count2 : {count2}</h6>
    </>)

}//func end