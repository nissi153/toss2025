//ex09-path.js
//path 모듈 사용하기
const path = require('path')

//path 모듈 : Window/Mac(Linux)
// 파일경로 : C:\users\me
//          /users/me
// OS 특성을 고려하여 파일경로에 대한 기능을 제공한다.

//경로 연결하기
// "some\work\test.txt" => "some/work/test.txt"
const fullPath = path.join('some', 'work', 'test.txt')
console.log(fullPath) //some\work\test.txt

//절대 경로 : C:\users\me\test.txt  /users/me/test.txt
//상대 경로 : .\test.txt  ./test.txt
// . : 현재 경로(디렉토리,폴더)
// .. : 현재 경로의 한단계 상위폴더  me폴더의 ..폴더는 users폴더이다.

//절대(전체) 경로
console.log(`파일 절대 경로 : ${__filename} `)
//C:\Users\pcuser\Documents\GitHub\toss2025\nodejs\basics\09-3-path.js

//폴더이름만 가져오기
const dir = path.dirname(__filename)
console.log(dir) //C:\Users\pcuser\Documents\GitHub\toss2025\nodejs\basics

//파일이름만 가져오기
const filename = path.basename(__filename)
console.log(filename) //09-path.js
//확장자 제외
const puerFilename = path.basename(__filename, '.js')
console.log(puerFilename) //09-3-path

//확장자만 가져오기
const ext = path.extname(__filename)
console.log(ext) //.js

puerFilename2 = path.basename(__filename, ext)
console.log(puerFilename2) //09-path

//경로 분해하기
const parsedPath = path.parse(__filename)
console.log(parsedPath)
console.log(parsedPath.name)
//{
//   root: 'C:\\',
//   dir: 'C:\\Users\\pcuser\\Documents\\GitHub\\toss2025\\nodejs\\basics',
//   base: 'ex09-path.js',
//   ext: '.js',
//   name: 'ex09-path'
// }
