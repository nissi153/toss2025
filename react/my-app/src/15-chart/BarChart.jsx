import React from "react";
import Chart from "chart.js/auto";
import { Bar } from "react-chartjs-2";

//리액트에서 chart.js를 사용하려면,
//chart.js, react-chartjs-2 모듈 2개를 설치한다.
//npm i chart.js react-chartjs-2

const BarChart = () => {
  const labels = ["January", "February", "March", "April", "May", "June"];
  const data = {
    labels: labels,
    datasets: [
      {
        label: "My First dataset",
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 159, 64, 0.2)",
          "rgba(255, 205, 86, 0.2)",
          "rgba(75, 192, 192, 0.2)",
          "rgba(54, 162, 235, 0.2)",
          "rgba(153, 102, 255, 0.2)",
        ],
        borderColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 159, 64, 0.2)",
          "rgba(255, 205, 86, 0.2)",
          "rgba(75, 192, 192, 0.2)",
          "rgba(54, 162, 235, 0.2)",
          "rgba(153, 102, 255, 0.2)",
        ],
        data: [5, 10, 5, 2, 20, 30],
      },
    ],
  };
  return (
    <div>
      <Bar data={data} />
    </div>
  );
};
export default BarChart;
