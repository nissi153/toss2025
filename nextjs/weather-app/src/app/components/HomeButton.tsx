'use client'
// 클라이언트 컴퍼넌트는 맨 말단으로 이동해야 된다.
// 그 밑에 서버 컴퍼넌트를 사용할 수 없다.

import { useRouter } from 'next/navigation'
import style from './style.module.css'

export default function HomeButton() {
  const router = useRouter()
  const handleClick = () => {
    router.push('/')
  }
  return (
    <button className={style.button} onClick={handleClick}>
      홈으로
    </button>
  )
}
