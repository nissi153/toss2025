import React from "react";
import { useState } from "react";
import axios from "axios";
//axios 모듈 설치
//npm i axios

//주요 차이점 비교
// 항목	Axios	Fetch
// 헤더 설정	자동으로 multipart/form-data 헤더를 적절히 설정함 (명시적으로 추가해도 문제 없음)
//            Content-Type은 설정하지 않아야 브라우저가 자동으로 경계(boundary)를 설정함
// 응답 처리	응답 데이터가 기본적으로 JSON으로 자동 파싱됨 (res.data)
//            응답을 명시적으로 response.json()으로 변환해야 함
// 에러 처리	네트워크 및 HTTP 상태 코드를 자동으로 구분하여 에러를 처리함
//            HTTP 오류도 수동으로 체크해야 함 (response.ok 확인 필요)
// 취소 가능 여부	axios.CancelToken을 사용해 요청을 쉽게 취소할 수 있음
//                AbortController를 사용해 취소해야 함
// 브라우저 지원	최신 브라우저와 Node.js 환경에서 모두 지원
//                최신 브라우저에서 기본적으로 지원하지만 구형 브라우저는 폴리필 필요
// 인터셉터 지원	요청 및 응답에 대해 인터셉터(중간 처리기)를 지원하여 로깅, 토큰 추가 등에 유용	기본적으로 인터셉터 없음.
//                추가 기능은 직접 구현해야 함
// 성능 및 크기	axios는 추가 의존성으로 인해 번들 크기가 다소 커질 수 있음
//                fetch는 브라우저 기본 API로, 추가 의존성이 없어 경량화됨
function FileUpload(props) {
  const [files, setFiles] = useState([]);

  const handleFilesChange = (e) => {
    setFiles(Array.from(e.target.files));
  };

  const uploadFiles = (e) => {
    e.preventDefault();
    const formData = new FormData();

    files.map((file) => {
      //"file"과 노드서버의 "file"이름이 일치해야 한다.
      formData.append("file", file);
    });

    console.log(Array.from(formData));

    axios
      .post("http://localhost:3030/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => {
        console.error(err);
      });

    fetch("http://localhost:3030/upload", {
      method: "POST",
      body: formData,
      //Content-Type은 설정하지 않아야 브라우저가 자동으로 경계(boundary)를 설정함
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("네트워크 응답이 올바르지 않습니다.");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.error("오류 발생:", error);
      });
  };

  return (
    <form>
      <input
        className="file-input"
        type="file"
        mulitple
        onChange={handleFilesChange}
      />
      <button onClick={uploadFiles}>upload</button>
    </form>
  );
}

export default FileUpload;
