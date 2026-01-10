import type { JSX } from "react"
import { GoChevronLeft } from "react-icons/go";
import { GoChevronRight } from "react-icons/go";
const CenterPart = ():JSX.Element => {
  const mainImages: String[] = [
    "/hero-image-1.png",
    "/hero-image-2.png",
    "/hero-image-3.png"

  ]
  return (
    <div
        className="w-[40%]  items-center relative flex flex-col h-full"
    >
      <img 
        alt="Image-for-Camera " 
        className="w-[75%] relative -top-15"
        src="/hero-image.png"
      />
      
     <div className="w-full flex gap-4 items-center justify-between">
       <button  
          title="LEFT"
          className="rounded-full cursor-pointer text-yellow-50 p-3 border-yellow-50 ">
          <GoChevronLeft size={27} />
       </button>
       <div className="flex gap-5 py-6 items-center justify-center">
          {mainImages.map((image: String, index: number) => (
            <img 
              key={index}
              src={image.toString()}
              alt={`hero-image-${index + 1}`}
              className="w-[80%] h-20 border border-orange-400"
            />
          ))}
        </div>
        <button 
          title="RIGHT"
          className="rounded-full cursor-pointer text-yellow-50 p-3 border-yellow-50 ">
          <GoChevronRight size={27} />
        </button>
     </div>
      
    </div>

  )
}

export default CenterPart