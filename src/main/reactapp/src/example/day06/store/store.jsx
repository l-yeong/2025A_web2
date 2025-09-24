import{configureStore} from '@reduxjs/toolkit';
import cartSlice from './cartslice.jsx';

// redux-persist 설정
import storage from 'redux-persist/lib/storage'
const persistConfig ={key:'cart',storage}

// 리듀서에 persist 설정 적용
import {persistStore, persistReducer} from 'redux-persist'
const persistedReducer = persistReducer(persistConfig,cartSlice);

//스토어 만들기
const store = configureStore({
    reducer:{
    //내가 만든 슬라이스 등록
    cart:persistedReducer
    }
})

//다른컴포넌트 스토어 호출할수있도록
export default store;

//등록된 퍼시스턴스 스토어 내보내기
export const persistor = persistStore(store);