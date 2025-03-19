import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux'; // react-redux로 변경
import { login } from '../redux/userSlice';

export default function Login() {
    //============================ 리덕스(전역변수)사용하기 ============================//
    // (1) 리덕스 사용하기 위한 useDispatch 함수 가져오기
    const dispatch = useDispatch(); // useDispatch 사용

    // (1) 입력받은 값들을 저장하는 state 변수 선언 , const [ 변수명 , set 변수명] = useState(초기값);
    const [memberInfo, setMemberInfo] = useState({ mid: '', mpwd: '' });

    // (2) 입력받은 값들을 수정하는 state 수정 처리 함수
    const onInputChange = (e) => {
        setMemberInfo({ ...memberInfo, [e.target.name]: e.target.value });
    };

    // (3) 입력받은 값들을 axios 이용하여 자바(스프링) 에게 요청과 응답받기
    const navigate = useNavigate(); // navigate 선언
    const onLogin = async () => {
        const response = await axios.post(
            'http://localhost:8080/api/member/login',
            memberInfo,
            { withCredentials: true }
        );
        const result = response.data;
        if (result === true) {
            // (4) 로그인 성공시 회원 정보를 가져오기.
            const response2 = await axios.get(
                'http://localhost:8080/api/member/info',
                {
                    withCredentials: true,
                }
            ); // end axios
            console.log(response2.data);
            alert('로그인 성공');
            navigate('/'); // navigate("/"); : 새로고침없다 vs location.href="/" : 새로고침있다
            //======================= 리덕스( 전역변수 )사용하기 ============================//
            // (2) useDispatch 함수를 이용한 리듀서 함수 액션하기. // 로그인 액션(함수) 에 (로그인한)회원정보를 대입한다. // 전역변수 대입
            dispatch(login(response2.data)); // useState(지역상태) 가 아닌 store(전역상태) 에 저장된다. response.data : payload
        } else {
            alert('로그인 실패');
        } // end if
    }; // end onLogin

    console.log(memberInfo);

    return (
        <>
            <h3>로그인페이지</h3>
            <form>
                아이디 :
                <input
                    type="text"
                    name="mid"
                    value={memberInfo.mid}
                    onChange={onInputChange}
                />{' '}
                <br />
                패스워드 :
                <input
                    type="password"
                    name="mpwd"
                    value={memberInfo.mpwd}
                    onChange={onInputChange}
                />{' '}
                <br />
                <button type="button" onClick={onLogin}>
                    로그인
                </button>
            </form>
        </>
    );
}
