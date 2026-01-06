import { Outlet } from 'react-router-dom'
const Layout = () => {
  return (
    <main className="bg-color">
        <Outlet />
    </main>
  )
}

export default Layout