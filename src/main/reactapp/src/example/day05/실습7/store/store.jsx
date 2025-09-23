import { configureStore } from '@reduxjs/toolkit';
import userSlice from "./userSlice";

/*
    스토어: 여러개의 상태를 보관하는 저장소, 1개 존재 해야한다.
    configureStore();
*/


// [1]스토어생성
const store= configureStore({
    reducer : {
        // [2]  내가만든 슬레이스(상태)를 등록한다. 상태명 : 슬라이스명
        user:userSlice
    }
});

// [3] 다른 컴포넌트에서 스토어 호출 할수 있도록 export
export default store;