import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Home from "./view/Home";
import Member from "./view/Member";

function App() {
  return (
      <Router>
          <Routes>
              <Route path={"/"} element={<Home/>}></Route>
              <Route path={"/members"} element={<Member />}></Route>
          </Routes>
      </Router>
  );
}

export default App;
