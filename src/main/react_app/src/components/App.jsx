import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Home.jsx';
import Header from './layouts/Header.jsx';
import Footer from './layouts/Footer.jsx';
import Signup from './member/Signup.jsx';
import Login from './member/Login.jsx';

export default function App() {
  return (
    <>
      <BrowserRouter>
        <div id="wrap">
          <Header />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/member/signup" element={<Signup />} />
            <Route path="/member/login" element={<Login />} />
          </Routes>
          <Footer />
        </div>
      </BrowserRouter>
    </>
  );
}
