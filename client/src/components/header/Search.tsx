import { BiSearch } from "react-icons/bi"
import type { JSX } from "react";
const Search = (): JSX.Element => {
  return (
    <div className="border-2 cursor-pointer bg-orange-500 text-white border-stone-800 rounded-full p-3">
        <BiSearch size={20}/>
        {/* <input 
            className="text-stone-800 text-lg outline-none ringe-none border-none" 
            placeholder='Search for product...'/> */}
    </div>
  )
}

export default Search