/**
 * 연습문제 1: 두 개의 숫자 입력 필드의 합 계산하기 (State 끌어올리기)
    문제 설명:
    두 개의 숫자 입력 필드를 만들고 입력한 숫자들의 합을 부모 컴포넌트에서 
    실시간으로 계산하여 출력합니다.
 */
import React, { useState } from "react";

// 첫 번째 숫자 입력 필드
function NumberInput1({ value, onChange }) {
  return (
    <div>
      <label>숫자 1: </label>
      <input
        type="number"
        value={value}
        onChange={(e) => onChange(Number(e.target.value))}
      />
    </div>
  );
}

// 두 번째 숫자 입력 필드
function NumberInput2({ value, onChange }) {
  return (
    <div>
      <label>숫자 2: </label>
      <input
        type="number"
        value={value}
        onChange={(e) => onChange(Number(e.target.value))}
      />
    </div>
  );
}

// 부모 컴포넌트
export function SumCalculator() {
  const [number1, setNumber1] = useState(0);
  const [number2, setNumber2] = useState(0);

  const sum = number1 + number2;

  return (
    <div>
      <h1>두 숫자의 합 계산하기</h1>
      <NumberInput1 value={number1} onChange={setNumber1} />
      <NumberInput2 value={number2} onChange={setNumber2} />
      <h3>합: {sum}</h3>
    </div>
  );
}
/**
 * 연습문제2: 선택한 리스트 항목 표시하기 (State 끌어올리기)
 * 문제 설명:
    리스트에 여러 항목(예: 과일 목록)이 주어져 있고, 사용자가 항목을 선택하면 
    선택한 항목들이 부모 컴포넌트에서 관리되어 화면에 표시됩니다.

    const items = ["사과", "바나나", "오렌지", "수박", "포도"];

    요구사항
    항목을 클릭하면 선택된 항목들이 부모 컴포넌트에 저장되어 표시됩니다.
    이미 선택된 항목을 클릭하면 해당 항목이 선택 목록에서 제거됩니다.
    상태는 부모 컴포넌트에서 관리합니다.
 */

// 리스트 항목 컴포넌트
function ItemList({ items, selectedItems, onItemSelect }) {
  return (
    <ul>
      {items.map((item, index) => (
        <li
          key={index}
          onClick={() => onItemSelect(item)}
          style={{
            cursor: "pointer",
            padding: "5px",
            backgroundColor: selectedItems.includes(item) ? "#d3d3d3" : "white",
          }}
        >
          {item}
        </li>
      ))}
    </ul>
  );
}

// 부모 컴포넌트
export function SelectableList() {
  const [selectedItems, setSelectedItems] = useState([]);

  const items = ["사과", "바나나", "오렌지", "수박", "포도"];

  // 항목 선택 및 해제
  const handleItemSelect = (item) => {
    setSelectedItems(
      (prevSelected) =>
        prevSelected.includes(item)
          ? prevSelected.filter((i) => i !== item) // 이미 선택되어 있으면 제거
          : [...prevSelected, item] // 새로 선택된 항목 추가
    );
  };

  return (
    <div>
      <h1>리스트 선택 및 연동</h1>
      <ItemList
        items={items}
        selectedItems={selectedItems}
        onItemSelect={handleItemSelect}
      />
      <h3>선택된 항목:</h3>
      <ul>
        {selectedItems.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
  );
}
