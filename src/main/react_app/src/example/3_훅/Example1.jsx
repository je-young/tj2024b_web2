let a = 0; // 전역변수 // 함수밖에
export default function Example1(props) {
  console.log(props); // {}

  let b = 0; // 지역변수 // 함수안에
  ++a; // a에 1증가
  ++b; // b에 1증가

  // 증가 버튼을 클릭했을때 실행되는 함수
  const 증가함수 = () => {
    ++a; // a에 1증가
    ++b; // b에 1증가
    // + innerHTML 안했기 때문에
    console.log(a); // 3 JS 에서는 변경 되었지만 HTML에는 반영이 안됨
    console.log(b); // 3 JS 에서는 변경 되었지만 HTML에는 반영이 안됨
    // 즉] 렌더링[새로고침] 필요로 한다. 왜? 함수의 return 1번 한다.
    // 즉] 한번 return 된 JSX 는 불변성이다.
    // 즉] return 이후에 JS 내 변수값이 변경되어도 HTML에는 변화가 없다.
  }; // 증가함수 end

  return (
    <>
      <h3> {++a} </h3> {/* 2 */}
      <h3> {++b} </h3> {/* 2 */}
      <button type="button" onClick={증가함수}>
        {' 증가함수 '}
      </button>
    </>
  ); // return end
} // Example1 end
