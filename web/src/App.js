import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Home from "./view/Home";

function App() {
  return (
      <Router>
          <Routes>
              <Route path={"/"} element={<Home/>}></Route>
          </Routes>
      </Router>
  );
}

export default App;
