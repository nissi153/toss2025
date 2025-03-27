import styles from './page.module.css'
import Link from 'next/link'
import { getCurrentWeather } from './utils/getCurrentWeather'

export default async function Home() {
  const json = await getCurrentWeather('seoul')
  console.log(json)

  return (
    <>
      <h1>날씨 앱</h1>
      <ul>
        <li>
          <Link href="/seoul">서울</Link>
          <span>{json.current.condition.text}</span>
        </li>
        <li>
          <Link href="/NYC">뉴욕</Link>
        </li>
        <li>
          <Link href="/london">런던</Link>
        </li>
      </ul>
    </>
  )
}
