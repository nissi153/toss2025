import styles from './page.module.css'
import Link from 'next/link'

const getCurrentWeather = async () => {
  const res = await fetch('')
  return res.json()
}

export default function Home() {
  return (
    <>
      <h1>Main Page</h1>
      <ul>
        <li>
          <Link href="/seoul">서울</Link>
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
