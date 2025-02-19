mini-blog-app 프로젝트

1. react 폴더에서
2. mini-blog-app 프로젝트 생성
3. npm create vite@latest
4. cd mini-blog-app
5. npm install react-router-dom styled-components
6. code .
7. npm run dev

/mini-blog-app
├── src
│ ├── components
│ │ ├── list
│ │ │ ├── CommentList.jsx
│ │ │ ├── CommentListItem.jsx
│ │ │ ├── PostList.jsx
│ │ │ ├── PostListItem.jsx
│ │ ├── pages
│ │ │ ├── MainPage.jsx
│ │ │ ├── PostViewPage.jsx
│ │ │ ├── PostWritePage.jsx
│ │ ├── ui
│ │ │ ├── Button.jsx
│ │ │ ├── TextInput.jsx
│ ├── App.jsx
├── package.json
├── data.json
├── main.jsx

### 프로덕션 배포하기

npm run build

빌드된 파일 실행
npm install -g serve
serve -s dist

### dist폴더를 Github Pages에 배포하기 위한 모듈

npm install -g gh-pages

### package.json

"scripts": {
"build": "vite build",
"predeploy": "npm run build",
"deploy": "gh-pages -d dist"
}

npm run deploy
