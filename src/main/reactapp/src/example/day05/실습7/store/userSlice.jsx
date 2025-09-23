import {createSlice} from '@reduxjs/toolkit';

/*
    슬라이스 : 상태(state), 리듀서(reducer), 액션(action) 정의하는곳
    createSlice
 */

// [1] 상태의 초기값 정의, 로그인 여부
const initialState={isAuthenticated : false, userInfo : null}

// [2] 슬라이스 정의
const userSlice = createSlice({
    name:"user", //slice의 상태명
    initialState, //정의한 객체로 초기값을 설정
    reducers : {  //여러개의 상태 변경 함수 정의한곳, {함수명:(state)=>{}, 함수명:(state)=>{}}
        login:(state,action)=>{state.isAuthenticated=true; //로그인 여부 true로 변경
            //action 할때 전달되는 매개변수들을 payload 안에 값이 들어있다.
            //예] dispatch(login("안녕")), payload="안녕"
            state.userInfo=action.payload; 

        },
        logout:(state)=>{state.isAuthenticated=false;//로그인 여부 false로 변경
            state.userInfo=null;
        }
    }
})

// [3] store에 저장할수 있게 export 해주기
export default userSlice.reducer; //현재 정의 리듀서(reducers)들을 store 등록 예정
// [4] 다른 컴포넌트에서 액션이 가능하도록 login, logout export 해주기
export const {login,logout}=userSlice.actions;
