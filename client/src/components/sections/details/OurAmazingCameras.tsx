import React from 'react'
import DisplayImazingCameras from './DisplayImazingCameras'

const OurAmazingCameras = ():React.JSX.Element => {
  return (
    <div className='h-screen py-15 items-center  flex flex-col gap-6'>
        <h1 className='title-font text-center w-[70%] leading-24'>
            Our Exclusive Camera just for you
        </h1>
        <DisplayImazingCameras />
      
    </div>
  )
}

export default OurAmazingCameras