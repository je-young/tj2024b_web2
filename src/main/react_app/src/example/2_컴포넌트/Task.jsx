/*
  리액트 과제1 : 아래 코드들을 사용하여 결과 에서 구현하여 제출
    조건1 : 두개의 컴포넌트 모두 활용 하시오.
*/

// 컴포넌트란? 1.클래형컴포넌트 2.함수형컴포넌트(*)
// ProductCard 컴포넌트 : 하나의 제품정보를 표현하는 UI 구역        (하위)
// Task 컴포넌트 : 여러개의 ProductCard 컴포넌트를 포함하는 UI 구역 (상위)

// ProductCard 컴포넌트 정의
const ProductCard = ({ title, price, instock }) => {
  // JSX 요소 반환
  return (
    <div
      // 스타일 속성 정의
      style={{
        border: '1px solid gray',
        padding: '10px',
        margin: '10px',
        backgroundColor: 'white',
        color: 'black',
      }}
    >
      <h3> {title} </h3>
      <p> 가격 : {price.toLocaleString()}원 </p>
      <p style={{ color: instock ? 'green' : 'red' }}>
        {instock ? '재고 있음' : '재고 없음'}
      </p>
    </div>
  ); // JSX 요소 반환 끝
}; // ProductCard 컴포넌트 끝

// Task 컴포넌트 정의
export default function Task(props) {
  console.log(props);

  // products 배열 정의
  const products = [
    // 각 제품 정보를 객체로 정의
    { title: '무선 키보드', price: 45000, instock: true },
    { title: '게이밍 마우스', price: 32000, instock: false },
    { title: '27인치 모니터', price: 280000, instock: true },
  ]; // products 배열 끝

  // JSX 반환
  return (
    <div style={{ padding: '20px' }}>
      <h2> 제품목록 </h2>
      <div
        // 스타일 속성 정의
        style={{
          display: 'flex',
          flexWrap: 'wrap',
          gap: '10px',
        }}
      >
        {products.map((product, index) => (
          // ProductCard 컴포넌트 호출
          <ProductCard
            // key 속성 정의
            key={index}
            // title, price, instock props 전달
            title={product.title}
            price={product.price}
            instock={product.instock}
          />
        ))}
      </div>
    </div>
  ); // JSX 반환 끝
} // Task 컴포넌트 끝
