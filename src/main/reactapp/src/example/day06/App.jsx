import {BrowserRouter,Route,Routes} from 'react-router-dom';
import CartPage from './pages/CartPage';
import HomePage from './pages/HomePage';
import MenuPage from './pages/MenuPage';
import Header from './components/Header';

export default function App(props){
    return(<>
    <BrowserRouter>
    <Header />
    <h3>루트페이지 실습8</h3>
    <Routes>
        <Route path='/' element={<HomePage/>}/>
        <Route path='/menu' element={<MenuPage/>}/>
        <Route path='/cart' element={<CartPage/>}/>
    </Routes>
    </BrowserRouter>
    </>)
}//func end