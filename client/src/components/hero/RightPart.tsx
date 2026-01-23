import { FaStar } from "react-icons/fa6"
import type { JSX } from "react";
const RightPart = (): JSX.Element => {
  return (
    <div className='w-[30%] flex flex-col  gap-5 justify-center px-5'>
      {/* top one */}
      <div className="flex flex-col gap-5">
        <div className='flex justify-around px-7 items-center'>
          {Array.from({ length: 6 }).map((_, index) => (
            <FaStar key={index} size={22} className="text-yellow-300" />
          ))}
        </div>
        <p className="tex-xl text-yellow-50 ">
          I couldn't be happier with my purchase! The camera's image quality is outstanding,
          capturing every detail with vibrant colors.
        </p>
      </div>

      {/* bottom one */}
      <div className="w-full border-orange-500/60 rounded-lg border p-1 h-full">
            <video
              className="w-full h-full object-cover"
              autoPlay
              loop
              muted
              playsInline
              src="/videos/main-video.mp4"
            />
      </div>
    </div>
  )
}

export default RightPart