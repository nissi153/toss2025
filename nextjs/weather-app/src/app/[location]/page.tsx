import HomeButton from '../components/HomeButton'
import { getForecast } from '../utils/getForecast'

export function generateMetadata() {
  return {
    title: '상세 날씨 데이터',
    description: '상세 날씨 데이터입니다.',
  }
}

type Props = {
  params: {
    location: string
  }
}

export default async function Detail({ params }: Props) {
  const { location } = await params
  const name = location === 'seoul' ? '서울' : location

  const json = await getForecast(location)
  console.log(json)

  return (
    <>
      <h1>{name}의 3일치 날씨 예보</h1>
      <ul>
        {json.forecast.forecastday.map((day) => (
          <li key={day.date}>
            {day.date} / {day.day.avgtemp_c}℃
            <br />
            <img
              src={`http:${day.day.condition.icon}`}
              alt={day.day.condition.text}
            />
            <span>{day.day.condition.text}</span>
          </li>
        ))}
      </ul>
      <br />
      <HomeButton />
    </>
  )
}
