// import { useState } from "react";
// import reactLogo from "./assets/react.svg";
// import viteLogo from "/vite.svg";
import "./App.css";
import Buttons from "./components/Buttons";
import SomeComponent from "./components/SomeComponent";
// import { useEffect } from "react";
// import { userManager } from "./helpers/auth_helper";
import SigninCallback from "./signin-callback";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  // const [count, setCount] = useState(0);

  // useEffect(() => {
  //   userManager
  //     .signinRedirectCallback()
  //     .then(() => {
  //       // Callback verarbeitet, kannst jetzt User laden
  //       console.log("Login callback processed");
  //     })
  //     .catch(() => {
  //       // Kein Callback, einfach ignorieren
  //     });
  // }, []);

  return (
    <>
      <Router>
        <Routes>
          <Route
            path="/"
            element={
              <div>
                <h1>Meine App</h1>
                <Buttons />
                <SomeComponent />
              </div>
            }
          />
          <Route path="/signin-callback" element={<SigninCallback />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
