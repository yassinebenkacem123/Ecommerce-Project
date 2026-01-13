import { GiStarShuriken } from "react-icons/gi"
import type { CameraInfo } from "../../../lib/type"
import type { JSX } from "react"
import { MdKeyboardArrowDown } from "react-icons/md";

const CameraCard = ({camera}:{camera:CameraInfo}): JSX.Element => {
  return (
    <div className="p-4 border flex justify-between items-center border-stone-700/30 ">
        {/* icon */}
        <div className="rounded-full  relative bg-gray-400/10 text-stone-800 p-4">
            <GiStarShuriken size={30}/>
        </div>

        {/* name */}
        
        <h1
            className="text-3xl font-bold text-stone-800"
        >
            {camera.name}
        </h1>

        {/* button */}
        <button title="view camera details" 
            className="p-6 text-stone-800/50 rounded-full border border-stone-700/40 cursor-pointer ">
            <MdKeyboardArrowDown size={25} />
        </button>
    </div>
  )
}

export default CameraCard