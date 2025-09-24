import {createSlice} from '@reduxjs/toolkit';

//상태의초기값 정의
const initialState=[];

const cartSlice=createSlice({
    name:"cart",
    initialState,
    reducers:{
        menu:(state,action)=>{
            const item = state.find( m => m.id === action.payload.id);
            if(item){
                item.quantity +=1;
            }else{
                state.push({...action.payload,quantity:1})
            }
        }

    }
})
// store 저장할수있게
export default cartSlice.reducer;

// 다른컴포넌트에서 액션 가능하도록
export const{menu} = cartSlice.actions;