function Greeting() {
  return <h1 className="greeting">Hello World2~</h1>;
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(React.createElement(Greeting));
