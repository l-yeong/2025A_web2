/*
    [web1]  백틱 템플릿 : 키보드 [tab] 위에 `(백틱) 기호 이용한 문자열내 js코드 연결 방법
                 예] name  = "유재석"
                `<div> ${name} </div>`
    [web2]  JSX 템플릿 : 리액트내 자동 포함
                예] let name = "유재석";
                return <div> { name } </div>
*/ 


//[1] 컴포넌트/함수 선언
export default function Component3(props){
    // ----------> JS 코드 START
    let name = "유재석"
    // <---------- JS 코드 END : return 전 까지

    // ----------> JSX 코드 START : return 부터는 JSX 문법
    return(<><div> <Header /> {name}입니다. <Footer /></div>
                {/* 다른 컴포넌트 포함하기 */}
                <SubCom1 key1="value1" key2="40"/>
                <SubCom1 key1="유재석" key2="60"/>
        </>)

    // <---------- JSX 코드 END
}//func end


function Header(props){
    return <div> Component3 <div>헤더메뉴</div> </div>
        
}//func end

function Footer(props){
    return (<><div> 푸터 메뉴 </div> <div>Component3</div></>)
}//func end

//[2] 컴포넌트/함수 선언2
function SubCom1(props){

    const obj = {name:"강호동",age:50};
    console.log(obj);
    
    console.log(props) // 2-1 : props 확인 // {key1:'value',key2:'40'}
    const { key1,key2 } = props; // 2-2 : props(배열/객체)구조 분해(쪼개기)
    // <----------------------------------- JSX 문법 ----------------------------------->
    return(<>
    <h4>{obj.name} 님의 나이는 {obj.age} 입니다.</h4>
    <h4>{props.key1} 님의 나이는 {props.key2} 입니다.</h4>
    <h4>{key1} 님의 나이는 {key2} 입니다.</h4>
    </>)
}//func end