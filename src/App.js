//index.js는 안주어도됨 -> 생략 가능! => 이런방식은 Component의 이름을 알 필요가 없음 -> 이름이 중복되는 경우 사용
import Kiosk from "./components/Ex1/";
import CountContainer from "./components/Counter/CountContainer";

function App() {
  return (
    <div className="App">
        <Kiosk></Kiosk>
    </div>
  );
}

export default App;
