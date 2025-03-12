// 리액트 컴포넌트 (src/ImageUpload.jsx)
import React, { useState } from "react";

const ImageUpload = () => {
  const [selectedFile, setSelectedFile] = useState(null);
  const [uploadStatus, setUploadStatus] = useState("");
  const [previewUrl, setPreviewUrl] = useState("");

  // 파일 선택 핸들러
  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      setSelectedFile(file);

      // 이미지 미리보기 생성
      const fileReader = new FileReader();
      fileReader.onload = () => {
        setPreviewUrl(fileReader.result);
      };
      fileReader.readAsDataURL(file);
    }
  };

  // 파일 업로드 핸들러 (fetch 사용)
  const handleUpload = async () => {
    if (!selectedFile) {
      setUploadStatus("파일을 먼저 선택해주세요.");
      return;
    }

    try {
      const formData = new FormData();
      formData.append("image", selectedFile);
      formData.append("id", "hong");
      formData.append("pw", "1234");

      const response = await fetch("http://localhost:3030/upload", {
        method: "POST",
        body: formData, // fetch 사용 시 headers 설정 불필요
      });

      if (!response.ok) {
        throw new Error(`서버 오류: ${response.status}`);
      }

      const data = await response.json();
      setUploadStatus(`업로드 성공: ${data.message}`);
    } catch (error) {
      console.error("업로드 오류:", error);
      setUploadStatus(`업로드 실패: ${error.message}`);
    }
  };

  return (
    <div className="image-upload-container">
      <h2>이미지 업로드</h2>

      <div className="file-input-container">
        <input type="file" accept="image/*" onChange={handleFileChange} />
      </div>

      {previewUrl && (
        <div className="image-preview">
          <h3>이미지 미리보기</h3>
          <img
            src={previewUrl}
            alt="선택한 이미지"
            style={{ maxWidth: "300px" }}
          />
        </div>
      )}

      <button onClick={handleUpload}>업로드</button>

      {uploadStatus && (
        <div className="upload-status">
          <p>{uploadStatus}</p>
        </div>
      )}
    </div>
  );
};

export default ImageUpload;
