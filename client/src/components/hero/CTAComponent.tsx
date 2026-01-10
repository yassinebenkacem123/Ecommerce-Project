import LeftPart from "./LeftPart"
import CenterPart from "./CenterPart"
import RightPart from "./RightPart"
import type { JSX } from "react";
const CTAComponent = ():JSX.Element => {
  return (
    <div className='flex justify-between gap-3 py-8 px-4 bg-stone-900'>
        <LeftPart   />
        <CenterPart />
        <RightPart  />
    </div>
  )
}

export default CTAComponent