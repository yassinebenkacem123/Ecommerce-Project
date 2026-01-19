
const ShownCreativity = () => {
  return (
    <section className="min-h-screen gap-30 py-15 flex flex-col">
        <h1 className="title-font text-center leading-30">
            Crafted for creatives your lens to the world
        </h1>
        <div className="w-full h-0.5 bg-stone-300/60"/>
        <div className="flex gap-10 ">
            {/*  */}
            <div className="w-[50%] h-100 relative bg-amber-300">
                <img 
                    className="absolute z-10 w-full bottom-0"
                    src="/special-image.png" 
                    alt="special image"  
                />
                <div className="text-[9rem] relative   overflow-hidden text-stone-700 opacity-20 bg-amber-300 w-112 rotate-10 font-semibold -bottom-40 left-55">
                   <h1 className="relative ">
                        FOCUS
                    </h1> 
                </div>
            </div>
            <div className="w-[50%]">
                <div>
                    <h1></h1>
                </div>
                <div></div>
            </div>
        </div>
    </section>
  )
}

export default ShownCreativity