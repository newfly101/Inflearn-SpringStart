import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Home from "./view/Home";
import Member from "./view/Member";
import MemberList from "./view/MemberList";

function App() {
  return (
      <Router>
          <Routes>
              <Route path={"/"} element={<Home/>}></Route>
              <Route path={"/members/new"} element={<Member />}></Route>
              <Route path={"/members"} element={<MemberList />}></Route>
          </Routes>
      </Router>
  );
}

export default App;
