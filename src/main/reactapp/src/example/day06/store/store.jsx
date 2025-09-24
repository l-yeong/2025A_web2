import{configureStore} from '@reduxjs/toolkit';
import cartSlice from './cartslice.jsx';

//스토어 만들기
const store = configureStore({
    reducer:{
    //내가 만든 슬라이스 등록
    cart:cartSlice
    }
})

//다른컴포넌트 스토어 호출할수있도록
export default store;