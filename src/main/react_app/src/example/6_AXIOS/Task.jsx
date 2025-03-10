/*
  리액트 + Spring 과제4 : 리액트 전화번호부 만들기(과제3) + Spring 서버 + MyBatis
    조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 Spring 서버 에게 전송
    조건2 : (전체출력) 서버로부터 받은 모든 정보(이름, 전화번호)를 table 로 모두 출력하시오.
    조건3 : useState 사용, useEffect 사용, axios 사용, mybatis(어노테이션 이용) 사용

    작업폴더 : 
      1. 리액트는 example 폴더 -> 6_axios 폴더 -> task.jsx
      2. 스프링은 example 폴더 -> day07Task 폴더

    [참고1] : 3_훅 --> task2.jsx
    [참고2] : 6_AXIOS --> Example2.jsx
*/

import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Task(props) {
  console.log(props);

  // [1] 입력받은 데이터를 저장하는 폼 state 변수 , { name : '' , phone : '' } 초기값
  const [FormData, setFormData] = useState({
    name: '',
    phone: '',
  }); // FormData end

  // [2] 입력받은 데이터를 렌더링 하는 이벤트함수.
  const FormDataChange = (e) => {
    console.log(e.target); // 이벤트를 발생한 html dom(마크업/태그)
    console.log(e.target.name); // 이벤트를 발생한 html dom(마크업/태그)의 name 속성 값-return
    console.log(e.target.value); // 이벤트를 발생한 html dom(마크업/태그)의 value 속성 값-return
    // 스프레드 연산자 이용한 state 변수 변경
    // -> setXXXX( [...기존객체 , 새로운속성명 : 새로운값 ] ) *만약에 새로운 속성명이 이미 존재하면 수정.
    setFormData({
      ...FormData,
      [e.target.name]: e.target.value,
    }); // setFormData end
  }; // FormDataChange end

  // [3] 현재 state 변수를 스프링 서버에게 보내기 , axios 라이브러리 사용
  const onPost = async () => {
    try {
      const response = await axios.post(
        'http://localhost:8080/day07/task',
        FormData
      ); // axios.post end
      if (response.data == true) {
        alert('등록 성공');
        onFindAll();
        setFormData({ name: '', phone: '' }); // state 변수 초기화
      } // if end
    } catch (error) {
      console.log(error);
    } // try end
  }; // onPost end

  // [4] 서버로부터 받은 모든 정보(이름, 전화번호)를 table 로 모두 출력하시오.
  useEffect(() => {
    onFindAll();
  }, []); // (1) 컴포넌트 마운트(생성) 될때 최초 1번 실행 함수 // 컴포넌트 실행 될때 딱 1번 onFindAll() 함수 실행
  const [Boards, setBoards] = useState([]);
  const onFindAll = async () => {
    try {
      const response = await axios.get('http://localhost:8080/day07/task');
      setBoards(response.data); // 서버로 부터 받은 정보를 state 변수에 저장
    } catch (error) {
      console.log(error);
    } // try end
  }; // onFindAll end

  return (
    <div>
      <h4>
        리액트 + Spring 과제4 : 리액트 전화번호부 만들기(과제3) + Spring 서버 +
        MyBatis
      </h4>
      <h4>
        조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 Spring 서버 에게 전송
      </h4>
      <h4>
        조건2 : (전체출력) 서버로부터 받은 모든 정보(이름, 전화번호)를 table 로
        모두 출력하시오.
      </h4>
      <h4>조건3 : useState 사용, useEffect 사용, axios 사용, mybatis 사용</h4>
      <h3>연락처 입력</h3>
      <form>
        <label>이름 : </label>
        <input name="name" value={FormData.name} onChange={FormDataChange} />
        <label>전화번호 : </label>
        <input name="phone" value={FormData.phone} onChange={FormDataChange} />
        <button type="button" onClick={onPost}>
          등록
        </button>
      </form>
      <h3>연락처 목록</h3>
      <table border="1">
        <thead>
          <tr>
            <th>이름</th>
            <th>전화번호</th>
          </tr>
          {Boards.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.name}</td>
                <td>{item.phone}</td>
              </tr>
            );
          })}
        </thead>
      </table>
    </div>
  );
} // Task end
