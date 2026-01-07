import { Outlet } from 'react-router-dom'
import NavBar from '../components/header/NavBar'
const Layout = () => {
  return (
    <main className="bg-color px-12 md:px-15 lg:px-18">
        <NavBar/>
        <Outlet />
    </main>
  )
}

export default Layout