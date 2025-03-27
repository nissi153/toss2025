'use client'

import HomeButton from '../components/HomeButton'

type Props = {
  params: {
    location: string
  }
}

export default function Detail({ params }: Props) {
  const { location } = params
  const name = location === 'seoul' ? '서울' : location

  return (
    <>
      <h1>{name}의 3일치 날씨 예보</h1>
      <br />
      <HomeButton />
    </>
  )
}
