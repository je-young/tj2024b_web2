import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Create(props) {
  console.log(props);

  // [1] form 에서 입력받은 데이터들을 저장하는 상태변수 , 초기값 설정
  const [productForm, setProductForm] = useState({
    name: '',
    price: '',
    Comment: '',
  });

  // [2] 입력 이벤트 만들기 , e.target.속성명 : 현재 이벤트가 발생한 DOM 의 속성값 반환
  const onValueChange = (e) => {
    // e : event 약어 : onChange 실행 결과 정보를 매개변수로 받는다.
    // 스레드 연산자 , {...기존객체 , 새로운속성명 : 새로운값 }
    setProductForm({
      ...productForm,
      [e.target.name]: e.target.value,
    });
  }; // onValueChange end

  // [3] 제품등록 버튼을 클릭했을때 , axios 이용하여 서버와 통신하고 , navigate 이용하여 가상 URL 페이지 전환한다.
  const navigate = useNavigate();
  const onCreate = async () => {
    const response = await axios.post(
      'http://localhost:8080/day08/products',
      productForm
    );
    if (response.data == true) {
      alert('제품등록 성공');
      navigate('/read');
    } else {
      alert('제품등록 시패');
    } // if end
  }; // onCreate end

  return (
    <div>
      <h1>Create</h1>
      <form>
        제품명 :
        <input
          name="name"
          value={productForm.name}
          onChange={onValueChange}
        />{' '}
        <br />
        제품가격 :
        <input
          name="price"
          value={productForm.price}
          onChange={onValueChange}
        />
        <br />
        제품설명 :
        <textarea
          name="comment"
          value={productForm.comment}
          onChange={onValueChange}
        ></textarea>
        <br />
        <button type="button" onClick={onCreate}>
          제품등록
        </button>
      </form>
    </div>
  );
}
