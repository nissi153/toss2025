import HomeButton from '../components/HomeButton'
import { getForecast } from '../utils/getForecast'

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
            {day.date} / {day.day.avgtemp_c}
          </li>
        ))}
      </ul>
      <br />
      <HomeButton />
    </>
  )
}
