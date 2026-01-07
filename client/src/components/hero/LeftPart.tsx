import { MdKeyboardArrowRight } from "react-icons/md";
import type { JSX } from "react";
const LeftPart = (): JSX.Element => {
  return (
    <div className="flex px-4 justify-center w-[30%] flex-col gap-10">
        <h1 className="text-6xl text-yellow-50 font-medium">
            16 mega pixel HD digital Camera
        </h1>
        <div className="flex gap-5 items-center ">
            <button className="bg-orange-500 px-5 text-xl rounded-full py-4 flex gap-2 items-center text-white">
                Start Shopping
                <MdKeyboardArrowRight />
            </button>
            <button 
                title="See More"
                className="rounded-full border text-yellow-50 border-yellow-50 p-4">
                <MdKeyboardArrowRight size={25} />

            </button>
        </div>
    </div>
  )
}

export default LeftPart