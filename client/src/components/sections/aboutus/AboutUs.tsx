import React from 'react'

const AboutUs = () => {
  return (
    <section className='h-screen py-10 flex flex-col gap-10'>
        {/* Top part */}
        <div className='flex gap-5 items-center'>
            <h1 
                className='title-font w-[30%]'
                >Who We Are</h1>
            <p className='text-font w-[55%]'>
                We belive that every picture tells a story,
                Our mission is to sell cameras that help you capture those stories in the best possible way,
                And we are committed to providing you with the highest quality products and exceptional customer service.
            </p>
            <img
                className='w-[15%] brightness-40' 
                src="/camera-logo.png" alt="Camera Logo" />
        </div>

        {/* Bottom part */}
        <div></div>

    </section>
  )
}

export default AboutUs