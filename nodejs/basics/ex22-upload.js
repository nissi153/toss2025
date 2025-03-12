const express = require('express')
const multer = require('multer')
const path = require('path')
const fs = require('fs')

//파일업로드 지원 모듈 : multer
//npm i multer

//파일(jpg,jpeg,png,zip,pdf) 업로드
//방법 1: 서버PC에 직접 업로드 - 실습
//방법 2: 클라우드 AWS S3

// 사용자 정의 스토리지 엔진 생성
const storage = multer.diskStorage({
  // 파일이 저장되는 위치를 설정 (file: 업로드된 파일의 정보, cb: 콜백 함수)
  destination: (req, file, cb) => {
    // 업로드 폴더 경로 지정
    const uploadPath = 'public/img/'

    // 폴더가 없으면 폴더를 생성
    if (!fs.existsSync(uploadPath)) {
      fs.mkdirSync(uploadPath)
    }

    // 콜백 함수를 호출하여 업로드 경로를 전달
    cb(null, uploadPath)
  },

  // 저장할 파일 이름 지정
  filename: (req, file, cb) => {
    // 콜백 함수를 호출하여 변경된 파일 이름을 전달
    // file.fieldname: 폼 필드의 이름, Date.now(): 현재 시간 (밀리초), path.extname(file.originalname): 원본 파일의 확장자
    // 파일 이름 예: file-1633959266884.jpg
    // uuid4 모듈을 이용하여 유니크한 파일이름을 지정할 수도 있다.
    // 파일 이름 예: 18ac939-def19cs-***.jpg
    cb(
      null,
      file.fieldname + '-' + Date.now() + path.extname(file.originalname)
    )
  },
})

// 파일 확장자 필터 정의
const fileFilter = (req, file, cb) => {
  // 허용되는 파일 확장자 (허용위험: bat, sh, exe, bin)
  const allowedFileTypes = ['.jpg', '.jpeg', '.png']

  // 파일의 확장자와 허용된 확장자를 비교
  if (allowedFileTypes.includes(path.extname(file.originalname))) {
    cb(null, true)
  } else {
    cb(new Error('Invalid file type')) // 유효하지 않은 파일 형식
  }
}

// Multer 설정: 사용자 정의 스토리지를 설정하고 파일 크기 제한 및 파일 필터링 적용
const upload = multer({
  storage: storage,
  limits: { fileSize: 1024 * 1024 * 5 }, // 5MB 크기 제한
  fileFilter: fileFilter,
})

/* 3단계 코드와 동일 */
const app = express()
const port = 3030

const cors = require('cors')

app.use(
  cors({
    origin: '*', // 모든 출처 허용 옵션. true 를 써도 된다.
  })
)

app.use(express.urlencoded({ extended: true })) // form-data 파싱 가능
app.use(express.static('public')) // 정적 파일 제공

app.post('/upload', upload.single('image'), (req, res) => {
  console.log(`File uploaded: ${req.file.filename}`)
  console.log(`id: ${req.body.id}`) // req.body.id 사용
  console.log(`pw: ${req.body.pw}`) // req.body.pw 사용
  res.status(200).json({ message: 'File uploaded successfully.' })
})

app.listen(port, () => {
  console.log(`Server listening on port ${port}`)
})
