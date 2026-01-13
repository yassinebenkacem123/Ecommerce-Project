import { GiStarShuriken } from "react-icons/gi";
import type {JSX} from 'react'
const AboutUs = ():JSX.Element => {
  return (
    <section className='h-screen py-10 flex mb-20 flex-col gap-10'>
        {/* Top part */}
        <div className='flex gap-5 items-center'>
            <h1 
                className='title-font w-[30%]'
                >Who We Are</h1>
          
            <div className='w-[70%] flex items-center'>
                <p className='w-[75%] text-font'>
                We belive that every picture tells a story,
                Our mission is to sell cameras that help you capture those stories in the best possible way,
                And we are committed to providing you with the highest quality products and exceptional customer service.
                </p>
                <img
                    className='opacity-65 w-[25%]' 
                    src="/camera-logo.png" alt="Camera Logo" />
            </div>
        </div>

        {/* Bottom part */}
        <div className='flex justify-between gap-4 items-center'>
            <div className="rounded-full  relative p-">
                <div className="rounded-full top-2 left-20 relative bg-gray-400/20 text-stone-800 p-7">
                    <GiStarShuriken size={30}/>
                </div>
                <div className="w-40 absolute rotate-210 h-20 bg-orange-500 rounded-t-full"/>
            </div>
            <div className="bg-yellow-300 flex relative items-center justify-center w-[70%] h-80">
                <img
                    className="w-100 bottom-0 absolute"
                    alt="about section main image" 
                    src="/about-section-main.png"/>

            </div>
        </div>

    </section>
  )
}

export default AboutUs