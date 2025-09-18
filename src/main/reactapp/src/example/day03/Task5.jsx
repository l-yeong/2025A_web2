import axios from "axios";
import { useEffect, useState } from "react";

export default function Task5( props ){
    const [ tname , setName ] = useState('')
    const [ tphone , setPhone ] = useState('')
    const [ tage , setAge ] = useState('')
    

    //등록함수 정의
    const onAdd = async( ) => {
        const obj = { tname , tphone , tage }
        const response = await axios.post('http://www.localhost:8080/day08/task5',obj);
        console.log(response.data);
        taskPrint();
    }//func end

    // 출력할 데이터들을 관리하는 useState
    const [ members , setMembers ] = useState( [ ] );
    // 전체 출력할 데이터들을 axios 이용하여 스프링에게 요청
    const taskPrint = async()=>{
        const response = await axios.get('http://www.localhost:8080/day08/task5');
        console.log(response.data);
        setMembers(response.data);
    }//func end

    // 최초컴포넌트 실행시 출력함수 실행
    useEffect(()=>{taskPrint()},[]);

    // 삭제함수 정의
    const onDelete = async( deleteTno )=>{ console.log( deleteTno );
        const response = await axios.delete(`http://www.localhost:8080/day08/task5?tno=${deleteTno}`);
        const newMembers = members.filter( (numDelete)=> { return numDelete.tno != deleteTno ; })
        setMembers([...newMembers])
    
    }//func end

    //수정함수 정의
    const onUpdate =async( updateTno)=>{
        const obj ={tname,tphone,tage}
        const response =await axios.put(`http://www.localhost:8080/day08/task5?tno=${updateTno}`,obj)
        const newUpdate = members.map(member=> member.tno == updateTno ? {...member,...obj}:member)

        setMembers([...newUpdate]);
    }


    return (<>
        성명 : <input value={ tname } onChange={ (e)=>{ setName(e.target.value ) } } />
        연락처 : <input value={ tphone } onChange={ (e)=>{ setPhone( e.target.value) } }/>
        나이 : <input value={ tage } onChange={ (e)=>{ setAge( e.target.value ) } } />
        <button onClick={ onAdd }> 등록 </button> <br/>
        {   members.map( ( m ) => {
                return <div>
                        {m.tno} { m.tname } { m.tphone } { m.tage }
                        <button onClick={ ()=> { onDelete( m.tno ) }  }> 삭제 </button>
                        <button onClick={ ()=> { onUpdate( m.tno ) }  }> 수정 </button>
                    </div>
            })
        }
    </>)
}
