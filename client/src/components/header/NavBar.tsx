import Menu from "./Menu"
import Search from "./Search"
import Logo from "./Logo"
import { FaStore } from "react-icons/fa6";
import { FaUser } from "react-icons/fa6";
import type { JSX } from "react";
const NavBar = (): JSX.Element => {
  return (
    <nav className="flex border-b-2  border-stone-200 justify-between items-center py-6">
      <div className="flex items-center gap-5">
        <Menu/>
        <Search/>
      </div>
     
     {/* Logo */}
      <Logo/>


      <div className="flex gap-4 items-center justify-center">
        {/* products  */}
        <button
          title="products" 
          className="border cursor-pointer border-stone-800 rounded-full p-3">
          <FaStore  size={25}/>
        </button>

        {/* Login */}
        <button title="Login" 
          className="border cursor-pointer border-stone-800 rounded-full p-3">
          <FaUser size={25}/>
        </button>
      </div>

    </nav>
  )
}

export default NavBar