import { useEffect, useRef } from 'react';
import { gsap } from 'gsap';
import SplitType from 'split-type';
import Reveal from '../../utils/Reveal';

const Title = (): React.JSX.Element => {;



  return (
    <Reveal>
      <h1 
        className='w-full  text-transparent bg-linear-to-r bg-clip-text from-stone-800 via-yellow-400 to-orange-500 text-center text-[5.5rem] font-bold'>
        Turn Moments Into Masterpieces
      </h1>
    </Reveal>
  );
}

export default Title;