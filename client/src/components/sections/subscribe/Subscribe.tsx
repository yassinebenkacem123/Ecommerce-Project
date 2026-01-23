import StartDeco from "../../decoretors/StartDeco"
import { MdOutlineKeyboardArrowRight } from "react-icons/md";

const Subscribe = () => {
  return (
    <div className="flex py-10 px-7 justify-between bg-stone-200/40 h-screen gap-7 items-start">
        {/* left part. */}
        <div className="flex px-3 flex-col w-[60%] gap-4">
            <h1 className="text-9xl text-stone-800 font-medium  relative">
                Subscribe to 
                    <StartDeco 
                    bgColor="bg-white"
                    startSize={100}   
                    padding="p-2" 
                    position="absolute right-1/2 top-35"
                    startColor="text-amber-300"
                />
                <br/>
                Our newsletters
            </h1>
            <p className="text-font">
                Subscribe to our newsletter and be the first to know about new product launches, 
                and inspiring stories from the world of the photography.
                
            </p>
            <div className="flex gap-3 items-center">
                <div className="px-4 py-4 w-[60%] bg-white/80 rounded-full">
                    <input
                        required
                        placeholder="Enter your email."
                        className="outline-none border-none text-xl text-stone-800 w-full" 
                        type="text" />
                </div>
                <button className="bg-orange-500 px-6 py-4 rounded-full text-white text-2xl cursor-pointer flex gap-3 items-center">
                    Subscribe
                    <MdOutlineKeyboardArrowRight size={30}/>
                </button>
            </div>
        </div>

        {/* right part. */}
        <div className="w-[40%] justify-end flex ">
            <img 
                className="h-140 w-full"
                src="/image-for-sub.png" alt="image for subscribe section" />
        </div>

    </div>
  )
}

export default Subscribe