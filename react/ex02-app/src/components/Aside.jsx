import dogImg from "../img/dog.jpg";

export default function Aside() {
  return (
    <div className="w-[20%] ml-[20px] border-solid border-black border pl-[10px] pr-[10px]">
      <h4 className="font-bold mt-[20px]">Golden Retriever</h4>
      <img className="w-[200px]" src={puppyPng} alt="리트리버" />
      <ul>
        <li>● 기본특성</li>
        <li>● 단점</li>
        <li>● 키울 시 주의점</li>
        <li>● 파생 혼종견</li>
      </ul>
    </div>
  );
}
