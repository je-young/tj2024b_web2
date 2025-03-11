import { BrowserRouter, Route, Routes } from 'react-router-dom'; // 'npm i react-router-dom' 설치필요

// 라우터로 연결할 컴포넌트 import 가져온다.
import Home from './Home.jsx';
import Create from './Create.jsx';
import Read from './Read.jsx';
import Update from './Update.jsx';
import Delete from './Delete.jsx';
import SideBar from './SideBar.jsx';
// CSS import
import './app.css';

// App.jsx : 라우터(가상URL) 이용한 라이팅
export default function App(props) {
  console.log(props);
  return (
    <>
      <h1>App</h1>
      <BrowserRouter>
        {/* 모든 라우터를 감싼다. */}
        <div id="wrap">
          <SideBar />
          <Routes>
            {/* 가상으로 정의한 URL를 감싼다. */}
            <Route path="/" element={<Home />} />
            {/* 각 가상의 URL에 매핑한 컴포넌트 */}
            <Route path="/create" element={<Create />} />
            {/* 각 가상의 URL에 매핑한 컴포넌트 */}
            <Route path="/read" element={<Read />} />
            {/* 각 가상의 URL에 매핑한 컴포넌트 */}
            <Route path="/update" element={<Update />} />
            {/* 각 가상의 URL에 매핑한 컴포넌트 */}
            <Route path="/delete" element={<Delete />} />
            {/* 각 가상의 URL에 매핑한 컴포넌트 */}
          </Routes>
        </div>
      </BrowserRouter>
    </>
  ); // return end
} // App end
