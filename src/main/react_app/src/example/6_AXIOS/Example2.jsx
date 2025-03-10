import { useEffect, useState } from 'react';
import axios from 'axios';

export default function Example2(props) {
  console.log(props);

  // [1] 입력받은 데이터를 저장하는 폼 state 변수 , { writer : '' , content : '' , pwd : '' } 초기값
  const [FormData, setFormData] = useState({
    writer: '',
    content: '',
    pwd: '',
  }); // FormData end

  // [2] 입력받은 데이터를 렌더링 하는 이벤트함수.
  const FormDataChange = (e) => {
    console.log(e.target); // 이벤트를 발생한 html dom(마크업/태그)
    console.log(e.target.name); // 이벤트를 발생한 html dom(마크업/태그)의 name 속성 값 반환
    console.log(e.target.value); // 이벤트를 발생한 html dom(마크업/태그)의 value 속성 값-return
    // 스프레드 연산자 이용한 state 변수 변경
    // -> setXXXX( [...기존객체 , 새로운속성명 : 새로운값 ] ) *만약에 새로운 속성명이 이미 존재하면 수정.
    setFormData({
      ...FormData,
      [e.target.name]: e.target.value,
    });
  }; // FormDataChange end

  // [3] 현재 state 변수를 스프링 서버에게 보내기 , axios 라이브러리 사용
  const onPost = async () => {
    try {
      const response = await axios.post(
        'http://localhost:8080/day07/react',
        FormData
      ); // axios.post end
      if (response.data == true) {
        alert('등록 성공');
        onFindAll();
        setFormData({ writer: '', content: '', pwd: '' }); // state 변수 초기화
      } // if end
    } catch (error) {
      console.log(error);
    } // try end
  }; // onPost end

  // [4] 서버에 저장된 방문록 정보( 작성자 / 내용 / 비밀번호 여러개 ) 요청한다.
  useEffect(() => {
    onFindAll();
  }, []); // (1) 컴포넌트 마운트(생성) 될때 최초 1번 실행 함수 // 컴포넌트 생성될때 딱 1변 onFindAll() 함수 실행
  const [boards, setBoards] = useState([]);
  const onFindAll = async () => {
    try {
      const response = await axios.get('http://localhost:8080/day07/react');
      setBoards(response.data); // 서버로 부터 받은 정보를 state 변수에 저장
    } catch (error) {
      console.log(error);
    } // try end
  }; // onFindAll end

  return (
    <>
      <div>
        <h4> 입력 폼 </h4>
        <form>
          작성자 :
          <input
            type="text"
            value={FormData.writer}
            name="writer"
            onChange={FormDataChange}
          />
          방문록 :
          <input
            type="text"
            value={FormData.content}
            name="content"
            onChange={FormDataChange}
          />
          비밀번호 :
          <input
            type="password"
            value={FormData.pwd}
            name="pwd"
            onChange={FormDataChange}
          />
          <button type="button" onClick={onPost}>
            등록
          </button>
        </form>
        <table>
          <thead>
            <tr>
              <th> 번호 </th> <th> 작성자 </th> <th> 방문록내용 </th>
              <th> 비고 </th>
            </tr>
          </thead>
          <tbody>
            {boards.map((board, index) => {
              return (
                <tr key={board.num}>
                  <td> {index + 1}</td>
                  <td> {board.writer}</td>
                  <td> {board.content}</td>
                  <td> 수정버튼 / 삭제버튼 </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </>
  ); // return end
} // Example2 end
