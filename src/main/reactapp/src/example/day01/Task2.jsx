// CSS파일 불러오기 : import 'css파일경로'
import './Task2.css'

const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
  ]; 

  export default function Task2(props){
    return (<>
    <div class="products">
        <InfoCard product={products[0]} />
        {/* 구문 분해 
        <InfoCard title={products[0].title}
                     price={products[0].price}
                     inStock={products[0].inStock} />*/}
        <InfoCard product={products[1]} />
        <InfoCard product={products[2]} />
    </div>
    </>)
  }//func end


//하위 컴포넌트 : 재고 1개당 정보 구성하는 컴포넌트
function InfoCard(props){
    //구문 분해, props현재 상태: {product : {title,price,inStock}}
    const {title,price,inStock}=props.product
    console.log(title);console.log(price);console.log(inStock);
    return(<>
        <ul class="list">
            <li class="title">{title}</li>
            <li class="price">{price.toLocaleString()}</li>
            <li class="stock">{inStock==true?"재고있음":"재고없음"}</li>
        </ul>
    </>)
}//func end