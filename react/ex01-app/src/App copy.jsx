function App() {
  return (
    <div className="w-full p-0 m-0">
      <div className="w-full h-[80px] bg-purple-700 flex justify-center items-center">
        Header
      </div>
      <div className="w-full h-[80px] bg-green-700 flex justify-center items-center">
        Nav
      </div>
      <div className="w-full flex flex-row">
        <div className="w-[50%] h-[400px] bg-blue-400 flex justify-center items-center">
          Section
        </div>
        <div className="w-[50%] h-[400px] bg-yellow-500 flex justify-center items-center">
          Aside
        </div>
      </div>
      <div className="w-full h-[70px] bg-green-700 flex justify-center items-center">
        Footer
      </div>
    </div>
  );
}

export default App;
