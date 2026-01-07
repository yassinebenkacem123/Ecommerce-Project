import { Link } from "react-router-dom"
import type { JSX } from "react";
const Logo = (): JSX.Element => {
  return (
    <Link to="." className="text-stone-800 cursor-pointer text-3xl font-bold">
        Focus
        <span className="text-orange-500">Pro</span>
    </Link>
  )
}

export default Logo