import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Home.jsx';
import Header from './layouts/Header.jsx';
import Footer from './layouts/Footer.jsx';
import Signup from './member/Signup.jsx';
import Login from './member/Login.jsx';
import store from './redux/store';
import { Provider } from 'react-redux'; // react-redux로 변경

export default function App() {
    return (
        <>
            <Provider store={store}>
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
            </Provider>
        </>
    );
}
