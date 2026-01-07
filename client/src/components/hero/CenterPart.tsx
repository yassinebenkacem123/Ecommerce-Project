import type { JSX } from "react"
const CenterPart = ():JSX.Element => {
  return (
    <div
        className="w-[40%] py-7 h-full"
    >
        <img 
            alt="Image-for-Camera" 
            className="w-[80%]"
            src="/hero-image.png"/>
    </div>
  )
}

export default CenterPart