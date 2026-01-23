import { Outlet } from 'react-router-dom'
import NavBar from '../components/header/NavBar'
import Footer from '../components/sections/footer/Footer'
import { useLocation } from 'react-router-dom'
const Layout = () => {
  const location = useLocation();
  return (
    <div className='flex flex-col gap-10 bg-color'>
      <main className=" px-12 md:px-15 lg:px-18">
          {location.pathname !== '/login' && location.pathname !== '/register' &&
            <NavBar/>}
          <Outlet />
      </main>
      {location.pathname !== '/login' && location.pathname !== '/register' &&
        <Footer />}
    </div>
  )
}

export default Layout