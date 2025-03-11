import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

// Update 컴포넌트 정의
export default function Update(props) {
  console.log(props);

  // 제품 데이터를 저장할 상태 변수를 선언
  const [productForm, setProductForm] = useState({
    id: '',
    price: '',
    comment: '',
  });
  const onValueChange = (e) => {
    setProductForm({
      ...productForm,
      [e.target.name]: e.target.value,
    });
  };
  console.log(productForm);

  const navigate = useNavigate();
  const onUpdate = async () => {
    const response = await axios.put(
      'http://localhost:8080/day08/products',
      productForm
    );
    if (response.data == true) {
      alert('제품수정 성공');
      navigate('/read');
    } else {
      alert('수정 실패 : 없는 제품번호 또는 시스템 오류');
    } // if end
  }; // onUpdate end

  return (
    <div>
      <h1>수정 페이지</h1>
      <form>
        수정할제품번호 :{' '}
        <input name="id" value={productForm.id} onChange={onValueChange} />{' '}
        <br />
        새로운제품명 :{' '}
        <input
          name="name"
          value={productForm.name}
          onChange={onValueChange}
        />{' '}
        <br />
        새로운가격 :{' '}
        <input
          name="price"
          value={productForm.price}
          onChange={onValueChange}
        />{' '}
        <br />
        새로운설명 :{' '}
        <textarea
          name="comment"
          value={productForm.comment}
          onChange={onValueChange}
        ></textarea>{' '}
        <br />
        <button type="button" onClick={onUpdate}>
          {' '}
          수정{' '}
        </button>
      </form>
    </div>
  );
}
