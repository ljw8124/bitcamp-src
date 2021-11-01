import HelloPage from "./HelloPage";
import {
    BrowserRouter, //as Router
    Route,
    Switch
} from "react-router-dom";
import MainPage from "./MainPage";
import PorfoiloPage from "./PorfoiloPage";
import Page404 from "./Page404";
import Board from"./Board";

export default () => {
    return(
        <Switch>
            <Route path="/hello" component={HelloPage}></Route>
            <Route path="/main" component={MainPage}></Route>
            <Route path="/portfoilo" component={PorfoiloPage}></Route>
            <Route pate="/board" component={Board}></Route>
            <Route path="/" component={MainPage} exact={true}></Route>
            <Route path="" component={Page404}></Route>
        </Switch>
    )
}