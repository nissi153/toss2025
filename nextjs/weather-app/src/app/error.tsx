'use client'

import { useEffect } from 'react'

type Props = {
  error: Error
  reset: () => void
}

export default function Error({ error, reset }: Props) {
  useEffect(() => {
    console.log('------', error.message)
  }, [])

  let message = '알 수 없는 오류가 발생했습니다.'

  // http://localhost:3000/seoul/korea
  if (error.message.includes('404')) {
    message = '페이지를 찾을 수 없습니다(404)'
  } else if (error.message.includes('500')) {
    message = '서버 오류가 발생했습니다(500)'
  }

  return (
    <>
      <h1>{message}</h1>
      <button
        onClick={() => {
          reset()
        }}
      >
        새로고침
      </button>
    </>
  )
}
