
import './App.css';
import Sidebar from "./template/Sidebar";
import Pages from "./pages/";
import {BrowserRouter} from "react-router-dom";


//Rounter를 다른 Component에서 사용하기 위해 여기서 사용
function App() {
    return (
        <BrowserRouter>
            <Sidebar></Sidebar>
            <Pages></Pages>
        </BrowserRouter>
    );
}

export default App;
