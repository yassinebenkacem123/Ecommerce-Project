import type { JSX } from "react"
import StartDeco from "../../decoretors/StartDeco"
import { MdKeyboardArrowRight } from "react-icons/md";

const ExploreSection = (): JSX.Element => {
  return (
   
    <div className=' flex flex-col gap-10 py-15 px-15 bg-stone-900'>
      {/* Top div */}
      <div className="flex gap-5">
        
        <div className="w-[25%] relative">
          <img src="/exploreSection/image-1.jpg" alt="image-1" />

          {/* decorator. */}
          <div className="border-4 right-10 rounded-full absolute bottom-0 p-2 border-yellow-300">
            <div className="border-4 rounded-full border-yellow-300/70 p-2">
            <StartDeco 
              bgColor="bg-orange-500"
              padding="p-7"
              startSize={30}
              startColor="text-white"
            />
            </div>
          </div>

        </div>
        
        <div className="w-[50%] pt-10">
          <h1 className="text-9xl text-center font-semibold text-yellow-50">
            Explore Our Gallery
          </h1>
        </div>


        <div className="w-[25%] pt-20">
          <img src="/exploreSection/image-2.jpg" alt="image-2" />
        </div>
      </div>

      {/* Bottom div */}
      <div className="flex gap-10 relative">
        <img 
          className="w-[40%] h-80"
          src="/exploreSection/image-3.jpg" alt="image-3" />
          <p className="text-2xl text-yellow-50/70 w-[45%]">
            Discover a world of cameras, lenses, and photography gear in our extensive gallery. 
            Explore the latest models, read reviews, and find the perfect equipment to capture your vision. Dive into our gallery and let your photographic journey begin!
          </p>
          <button className="flex gap-2 w-[20%] h-17 cursor-pointer items-center justify-center absolute bottom-0 right-0 rounded-full bg-orange-500 text-white text-xl">
            Explore Gallery
            <MdKeyboardArrowRight size={30}/>
          </button>
      </div>
    </div>
    
  )
}

export default ExploreSection