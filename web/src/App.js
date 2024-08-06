import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Home from "./view/Home";
import Member from "./view/Member";
import MemberList from "./view/MemberList";
import {useEffect} from "react";
import axios from "axios";

function App() {
    useEffect(() => {
        const checkCORS = async () => {
            await axios.options("/", {
                headers: {
                    "Content-Type": "application/json",
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*",
                    "Access-Control-Allow-Method": "GET, DELETE, OPTIONS, POST"
                }
            });
        }
    }, []);
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
