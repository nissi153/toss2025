// import "./App.css";
import BarChart from "./BarChart";
import LineChart from "./LineChart";
import PieChart from "./PieChart";

const ChartApp = function ChartApp() {
  return (
    <>
      <LineChart />
      <BarChart />
      <PieChart />
    </>
  );
};

export default ChartApp;
