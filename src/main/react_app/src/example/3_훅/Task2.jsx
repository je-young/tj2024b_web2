/*
  리액트 과제3 : 리액트 전화번호부 만들기
    조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 배열에 저장
    조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
    조건3 : useState 사용.
*/

import { useState } from 'react'; // useState 함수 사용

// Task2 컴포넌트 생성
export default function Task2() {
  // 연락처 목록을 저장할 state
  const [contacts, setContacts] = useState([]); // state변수 선언
  // 입력값을 관리할 state
  const [name, setName] = useState(''); // state변수 선언
  const [phone, setPhone] = useState(''); // state변수 선언

  // 입력 폼 제출 시 실행되는 함수
  const handleSubmit = (event) => {
    // event 객체를 매개변수로 받음
    event.preventDefault(); // 기본 동작 방지
    if (name && phone) {
      // 이름과 전화번호가 모두 입력되었을 때만 실행
      // 입력값이 있을 때만 실행
      setContacts([...contacts, { name, phone }]); // contacts 배열에 새로운 객체 추가
      console.log('새로운 연락처 추가:', { name, phone }); // 새로 추가되는 데이터 확인
      console.log('전체 연락처 목록:', [...contacts, { name, phone }]); // 전체 배열 확인 목록 확인
      // 입력 필드 초기화
      setName(''); // state변수 초기
      setPhone(''); // state변수 초기
    } // if end
  }; // handleSubmit end

  return (
    // JSX 시작
    // JSX 코드
    <div>
      <h2>전화번호부</h2>

      {/* 입력 폼 */}
      <form onSubmit={handleSubmit}>
        {/* form 태그에 submit 이벤트 발생 시 handleSubmit 함수 실행 */}
        <input
          type="text"
          placeholder="이름"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
        {/* input 태그에 입력값이 변경될 때마다 setName 함수 실행 */}
        <input
          type="tel"
          placeholder="전화번호"
          value={phone}
          onChange={(event) => setPhone(event.target.value)}
        />
        {/* input 태그에 입력값이 변경될 때마다 setPhone 함수 실행 */}
        <button type="submit">저장</button>
      </form>

      {/* 연락처 목록 테이블 */}
      <table>
        <thead>
          <tr>
            <th>이름</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody>
          {/* 연락처 목록 출력 */}
          {/* map 함수로 contacts 배열을 순회하며 테이블 행 생성 */}
          {contacts.map((contact, index) => (
            <tr key={index}>
              <td>{contact.name}</td>
              <td>{contact.phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  ); // JSX 끝
} // Task2 end
