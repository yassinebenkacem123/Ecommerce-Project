import { MdPlayArrow } from "react-icons/md";

const ProductDetails = () => {
  return (
    <section className='py-10  mt-200 min-h-screen flex gap-10 flex-col items-center'>
      <h1 className='title-font flex flex-col'>
        Our Porduct <br/>
        <div className="flex gap-10 items-center">
          <div className="bg-amber-300 px-10 py-3 flex text-center justify-center items-center w-[60%] h-30 rounded-full">
            <img
              className="w-150 h-20" 
              src="/icons/right-arrow.png" alt="arrow" />
         </div>
         Details
        </div>
      </h1>


      <div className="flex gap-5 w-full">
        {/* left image */}
        <div className="p-3 relative flex justify-center items-center w-[50%] bg-stone-200/40">
          <div className="absolute top-4 flex flex-col gap-4 left-4">
             <h1 className="text-xl font-semibold">
                Canon EOS R6 
             </h1>
             <button className="bg-white/80 shadow-sm hover:bg-stone-800 hover:text-white duration-200  shadow-black/10 flex items-center gap-4 cursor-pointer rounded-full text-xl font-semibold px-5 py-3">
              learn more <MdPlayArrow size={30}/>
            </button>
           </div>
          <img
            className="rotate-90 w-105" 
            src="/filtered-image/canon-eos-1.png" alt="Canon-eosa-1" />
        </div>

        {/* two right images. */}
        <div className="flex w-[50%] flex-col gap-5">
          <div className="p-3 flex  items-center relative justify-center bg-stone-200/40">
           <div className="absolute top-4 flex flex-col gap-4 left-4">
             <h1 className="text-xl font-semibold">
                Canon EOS R6 
             </h1>
             <button className="bg-white/80 shadow-sm transition-all hover:bg-stone-800 hover:text-white duration-200  shadow-black/10 flex items-center gap-4 cursor-pointer rounded-full text-xl font-semibold px-5 py-3">
              learn more <MdPlayArrow size={30}/>
            </button>
           </div>
            <img
              className="w-70"
              src="/filtered-image/canon-eos-2.png" alt="Canon-eosa-1" />
          </div>
          <div className="p-3 flex justify-center items-center bg-stone-200/40">
            <img
              className="w-70" src="/filtered-image/canon-eos-3.png" alt="Canon-eosa-1" />
          </div>
        </div>
      </div>
    </section>
  )
}

export default ProductDetails