import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { logout } from '../redux/userSlice';

export default function Header() {
    // ======================= 리덕스 (전역변수) 사용하기. ======================= //
    // (1) 전역상태에서 로그인된 회원정보 불러오기, user 라는 이름의 리듀서 정보를 가져오기
    const loginInfo = useSelector((state) => state.user.userInfo);
    console.log(loginInfo);

    // (2) 로그아웃 하기 위한 useDispatch
    const dispatch = useDispatch();

    // (4) axios 이용하여 로그아웃 요청과 응답받기
    const navigate = useNavigate();
    const onLogout = async () => {
        const response = await axios.get(
            'http://localhost:8080/api/member/logout',
            {
                withCredentials: true,
            }
        );
        const result = response.data;
        if (result === true) {
            alert('로그아웃 했습니다.');
            navigate('/');
            dispatch(logout());
        } // end if
    }; // end onLogout₩

    return (
        <>
            <div>
                <h3> 헤더영역</h3>
                <ul>
                    <li>
                        {loginInfo ? (
                            <>
                                <div>
                                    {loginInfo.mid} 님 안녕하세요.
                                    <button onClick={onLogout}>로그아웃</button>
                                </div>
                            </>
                        ) : (
                            <>
                                <div>비로그인</div>
                            </>
                        )}
                    </li>
                    <li>
                        <Link to="/"> 홈으로 </Link>
                    </li>
                    <li>
                        <Link to="/member/signup"> 회원가입 </Link>
                    </li>
                    <li>
                        <Link to="/member/login"> 로그인 </Link>
                    </li>
                </ul>
            </div>
        </>
    );
}
