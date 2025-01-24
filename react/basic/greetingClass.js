class Greeting extends React.Component {
  render() {
    return <h1 className="greeting">Hello World1~</h1>;
  }
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(React.createElement(Greeting));
