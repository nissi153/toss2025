// localhost:3000/[location]
// localhost:3000/seoul
// localhost:3000/NYC
// localhost:3000/london
type Props = {
  params: {
    location: string
  }
  // params: Promise<{ location: string }>;
}
// next.js 13버전에서 async를 통해서 params 값을 얻어온다.
export default async function Detail({ params }: Props) {
  const { location } = await params
  console.log(location)

  const name = location === 'seoul' ? '서울' : location

  return (
    <>
      <h1>{name}의 3일치 날씨 예보</h1>
    </>
  )
}
