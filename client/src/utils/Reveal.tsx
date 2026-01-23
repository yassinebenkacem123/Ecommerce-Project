import type { JSX } from "react"
import {motion, useInView, useAnimation} from "framer-motion"   

import { useEffect, useRef } from "react"
interface Props {
    children: JSX.Element;
    width?:string;
}
const Reveal = ({children,width} : Props):JSX.Element => {
    const ref = useRef<HTMLDivElement | null>(null);
    const isInView = useInView(ref, {once:true});
    const mainControls = useAnimation();  
    const slideControls = useAnimation();
    useEffect(() => {
        if(isInView){
            // fire the animation
            mainControls.start("visible");
            slideControls.start("visible");
        }
    }, [isInView]);
    return (
    <div className={`${width}`} ref={ref} style={{position:"relative", overflow:"hidden"}}>
        <motion.div
            variants={{
                hidden:{opacity:0, y:75},
                visible:{opacity:1, y:0},
            }}
            initial="hidden"
            animate={mainControls}
            transition={{duration:0.75, delay:0.25}}

            >
            {children}
        </motion.div>
        <motion.div
            variants={{
                hidden:{left:0},
                visible:{left:"100%"}
            }}
            initial="hidden"
            animate={slideControls}
            transition={{duration:0.75, ease:"easeIn"}}
            style={{
                position:"absolute",
                top:0,
                bottom:0,
                left:0,
                right:0,
                background:"orange",
                zIndex:20,
            }}
        >

        </motion.div>
    </div>
  )
}

export default Reveal