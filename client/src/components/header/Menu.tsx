import { MdMenuOpen } from "react-icons/md";
import type { JSX } from "react";
const Menu = (): JSX.Element => {
  return (
    <button
        className="px-3 py-2 rounded-full border border-stone-800"
    >
        <div className="flex items-center justify-center gap-3">
            <MdMenuOpen size={25}/>
            <h1 className="text-xl text-stone-800">
                Menu
            </h1>
        </div>
    </button>
  )
}

export default Menu