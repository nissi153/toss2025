import Header from "./components/Header";
import "./components/movieStyle.css";
import Nav from "./components/Nav";
import Main from "./components/Main";
import Footer from "./components/Footer";

export default function App() {
  return (
    <>
      <div className="max_width">
        <Header />
      </div>
      <hr />
      <Nav />
      <div className="max_width">
        <Main />
      </div>
      <Footer />
    </>
  );
}
