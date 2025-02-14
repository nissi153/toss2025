import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./Navbar";
import HomePage from "./pages/HomePage";
import AboutPage from "./pages/AboutPage";
import ContactPage from "./pages/ContactPage";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route page="/" element={<HomePage />} />
        <Route page="/about" element={<AboutPage />} />
        <Route page="/contact" element={<ContactPage />} />
      </Routes>
    </Router>
  );
}

export default App;
