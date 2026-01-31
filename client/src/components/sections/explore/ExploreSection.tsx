import { useLayoutEffect, useRef, type JSX } from "react"

import bg from '/exploreSection/bg.jpg'

import img1 from '/exploreSection/image-1.jpg'
import img2 from '/exploreSection/image-2.jpg'
import img3 from '/exploreSection/image-3.jpg'
import img4 from '/exploreSection/image-4.jpg'
import gsap from "gsap"
import ScrollTrigger from "gsap/ScrollTrigger"
gsap.registerPlugin(ScrollTrigger);
const ExploreSection = (): JSX.Element => {
  const bg1 = useRef<HTMLDivElement>(null);
  const image_container = useRef<HTMLDivElement>(null);
  const img = useRef<HTMLImageElement>(null);
  const text1 = useRef<HTMLHeadingElement>(null);
  const text2 = useRef<HTMLParagraphElement>(null);
  const container = useRef<HTMLDivElement>(null) ;
  useLayoutEffect(()=>{
    let ctx = gsap.context(()=>{
        ScrollTrigger.create({
          trigger:bg1.current,
          pin:bg1.current,
          start:"top top",
          pinSpacing:false,
          end:"bottom bottom",
          endTrigger:".last"
        })
    });

    if (container.current) {
      const height = container.current.offsetHeight;
      gsap.set(container.current, { marginTop: -height });
    }
    gsap.timeline({
      scrollTrigger:{
        trigger:image_container.current,
        pin:image_container.current,
        start:"0% 0%",
        scrub:1,
      },
     
    }).to(img.current,
      {
        transform:"translateZ(2200px)"
      })
      .to(text1.current, 0.05, {y:-800}, "<")
      .to(text2.current, 0.08, {y:-800}, "<")
      .fromTo(container.current, 
        {yPercent:100, scaleY:2}
        ,{yPercent:0, scaleY:1}
      );
    return () => ctx.revert();
  },[])
  return (
   <>
      <div className="relative min-h-screen mb-85 mt-20">
        <div ref={bg1} className="bg bg-[#141414] absolute min-h-screen w-screen"></div>
        <section>
          <div ref={image_container} 
            className="img-container perspective flex items-center justify-center h-screen w-screen">
           <img 
           ref={img}
            className="image"
            src={bg} alt=""/>
            <div className="text-white absolute flex flex-col items-center justify-center">
              <h1
                ref={text1}
                className="text-[170px]">
                <span className="text-stroke">
                  Outllook 
                </span> Above
              </h1>
              <p
                ref={text2} 
                className="opacity-50 w-48 text-[13px] text-center">
                {" "}
                A showe case of the world's best aerial photography</p>
            </div>
          </div>
          <div  
          ref={container}
          className="container flex items-center justify-around flex-wrap">
            
            <div className="col-1 translate-y-[30%] pb-8 flex flex-col gap-15">
              <img
                className="w-112.5 h-100 " 
                src={img1} alt="" />
              <img
                className="w-100 h-100" 
                src={img2} alt="" />
            </div>


            <div className="col-2 flex flex-col z-14 gap-15 ">
              <img src={img3} alt="" className="w-150 h-100" />
              <img src={img4} alt="" className="w-110 h-145 last"/>
            </div>

          </div>
        </section>
       

      </div>

   </>
    // <div className=' flex flex-col gap-10 py-15 px-15 bg-stone-900'>
    //   {/* Top div */}
    //   <div className="flex gap-5">
        
    //     <div className="w-[25%] relative">
    //       <img src="/exploreSection/image-1.jpg" alt="image-1" />

    //       {/* decorator. */}
    //       <div className="border-4 right-10 rounded-full absolute bottom-0 p-2 border-yellow-300">
    //         <div className="border-4 rounded-full border-yellow-300/70 p-2">
    //         <StartDeco 
    //           bgColor="bg-orange-500"
    //           padding="p-7"
    //           startSize={30}
    //           startColor="text-white"
    //         />
    //         </div>
    //       </div>

    //     </div>
        
    //     <div className="w-[50%] pt-10">
    //       <h1 className="text-9xl text-center font-semibold text-yellow-50">
    //         Explore Our Gallery
    //       </h1>
    //     </div>


    //     <div className="w-[25%] pt-20">
    //       <img src="/exploreSection/image-2.jpg" alt="image-2" />
    //     </div>
    //   </div>

    //   {/* Bottom div */}
    //   <div className="flex gap-10 relative">
    //     <img 
    //       className="w-[40%] h-80"
    //       src="/exploreSection/image-3.jpg" alt="image-3" />
    //       <p className="text-2xl text-yellow-50/70 w-[45%]">
    //         Discover a world of cameras, lenses, and photography gear in our extensive gallery. 
    //         Explore the latest models, read reviews, and find the perfect equipment to capture your vision. Dive into our gallery and let your photographic journey begin!
    //       </p>
    //       <button className="flex gap-2 w-[20%] h-17 cursor-pointer items-center justify-center absolute bottom-0 right-0 rounded-full bg-orange-500 text-white text-xl">
    //         Explore Gallery
    //         <MdKeyboardArrowRight size={30}/>
    //       </button>
    //   </div>
    // </div>
    
  )
}

export default ExploreSection