import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Home.jsx';
import Header from './layouts/Header.jsx';
import Footer from './layouts/Footer.jsx';
import Signup from './member/Signup.jsx';
import Login from './member/Login.jsx';

// import 할때 export default 적용된 자료는 { } 생략해도 된다. 여러개 또는 default 아닌 자료에 대해서는 { } 사용한다.
import { store, persistor } from './redux/store';
import { Provider } from 'react-redux'; // react-redux로 변경
import { PersistGate } from 'redux-persist/integration/react'; // PersistGate 라이브러기 가져오기

export default function App() {
    return (
        <>
            <Provider store={store}>
                <PersistGate persistor={persistor} loading={null}>
                    <BrowserRouter>
                        <div id="wrap">
                            <Header />
                            <Routes>
                                <Route path="/" element={<Home />} />
                                <Route
                                    path="/member/signup"
                                    element={<Signup />}
                                />
                                <Route
                                    path="/member/login"
                                    element={<Login />}
                                />
                            </Routes>
                            <Footer />
                        </div>
                    </BrowserRouter>
                </PersistGate>
            </Provider>
        </>
    );
}
