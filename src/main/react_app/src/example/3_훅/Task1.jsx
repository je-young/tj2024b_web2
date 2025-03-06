/*
  리액트 과제2 : 아래 코드들을 사용하여 입력된 값들의 글자수를 실시간으로 출력하시오.
*/

import { useState } from 'react'; // useState 함수 사용
export default function Task1() {
  //console.log('Task1 실행'); // Task1 실행 콘솔 출력
  // Task1 컴포넌트 생성
  // (1) 여기에 state 변수 만들기
  const [inputvalue, setInputValue] = useState(''); // state변수 선언
  //console.log(inputvalue); // state변수 콘솔 출력
  //console.log(setInputValue); // state변수 콘솔 출력

  // input에 입력된 값이 변경될 때 실행되는 함수
  const handleChange = (event) => {
    //console.log(event); // 이벤트 객체 콘솔 출력
    //console.log(event.target); // 이벤트 객체의 대상 콘솔 출력
    // (2) 여기에서 state 변수값 수정하기.
    setInputValue(event.target.value); // input에 입력된 값을 state변수에 저장
    console.log(event.target.value); // input에 입력된 값 콘솔 출력
  }; // handleChange end

  return (
    // JSX 문법
    <>
      <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
      <input value={inputvalue} onChange={handleChange} />
      {/* input에 입력된 값이 변경될 때 handleChange 함수 실행 */}
      <p>글자 수: {inputvalue.length} </p>
      {/* 글자 수 출력 */}
    </>
  ); // return end
} // Task1 end
