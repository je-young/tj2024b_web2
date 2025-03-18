import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
// import './index.css';
// import App from '../../react_app/src/App.jsx';

// 1. 기본 코드 주석처리
// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

// (*) index.html 에 root 구역 가져오기.
const root = createRoot(document.querySelector('#root'));
// (*) 최초로 보여줄 컴포넌트 가져오기
import App from './components/App';
root.render(<App />);

// day01 : '컴포넌트 만들기' 렌더링
// import 호출할 컴포넌트명 from '경로/파일명(확장자)';
//import Component1 from './example/1_동작구조/Component1.jsx';
//root.render(<Component1 />);

// day01 : 여러 컴포넌트 만들기
//import Component2 from './example/1_동작구조/Component2.jsx';
//root.render(<Component2 />);

// day02 : 컴포넌트의 JSX 활용
//import Example1 from './example/2_컴포넌트/Example1.jsx';
//root.render(<Example1 />);

// day02 : 컴포넌트의 Props 활용
//import Example2 from './example/2_컴포넌트/Example2.jsx';
//root.render(<Example2 />);

// day02 : 과제1
//import Task from './example/2_컴포넌트/Task.jsx';
//root.render(<Task />);

// day03 : 생명주기1
//import Example1 from './example/3_훅/Example1.jsx';
//root.render(<Example1 />);

// day03 : 생명주기2
//import Example2 from './example/3_훅/Example2.jsx';
//root.render(<Example2 />);

// day03 : 생명주기3
//import Example3 from './example/3_훅/Example3.jsx';
//root.render(<Example3 />);

// day03 : 과제2
//import Task1 from './example/3_훅/Task1.jsx';
//root.render(<Task1 />);

// day03 : 과제3
//import Task2 from './example/3_훅/Task2.jsx';
//root.render(<Task2 />);

// day03 : 과제3-강의
//import Task1 from './example/3_훅/Task2_강의.jsx';
//root.render(<Task1 />);

// day04 :
//import Example1 from './example/4_훅2/Example1.jsx';
//root.render(<Example1 />);

// day04 :
//import App from './example/5_라우터/Example1.jsx';
//root.render(<App />);

// day05 : axios
//import Example1 from './example/6_AXIOS/Example1.jsx';
//root.render(<Example1 />);

// day05 : axios 2
//import Example2 from './example/6_AXIOS/Example2.jsx';
//root.render(<Example2 />);

// day05 : 과제4
//import Task from './example/6_AXIOS/Task.jsx';
//root.render(<Task />);

// day06 : 라우터 컴포넌트 렌더링
//import App from './example/7_AXIOS2/App.jsx';
//root.render(<App />);

// day07 :
//import Example1 from './example/8_MUI/Example1';
//root.render(<Example1 />);

// day07 : MUI
//import Example2 from './example/8_MUI/Example2';
//root.render(<Example2 />);
