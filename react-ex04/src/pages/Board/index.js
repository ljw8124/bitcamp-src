import {Route, Switch} from "react-router-dom";
import BoardListPage from "./BoardListPage";
import BoardRegisterPage from "./BoardRegisterPage";

//Switch는 위에서부터 적용되어 내려감
export default () => {
    return(
        <Switch>
            <Route path="/board/list" component={BoardListPage}></Route>
            <Route path="/board/register" component={BoardRegisterPage}></Route>
            <Route path="/board" component={BoardListPage}></Route>
        </Switch>

    )
}