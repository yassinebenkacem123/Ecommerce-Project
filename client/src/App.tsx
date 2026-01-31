import { Routes, Route } from "react-router-dom"
import Layout from "./layout/Layout"
import Home from "./pages/Home"
import Register from "./pages/Register"
import Login from "./pages/Login"
import {AnimatePresence} from "framer-motion"
import Products from "./pages/product/Products"
function App() {

  return (
  <AnimatePresence mode="wait">
    <Routes>
      <Route path="/" element={<Layout  />}>
        <Route index element={<Home />}/>
        <Route path="products" element={<Products />}/>
        <Route path="login" element={<Login />}/>
        <Route path="register" element={<Register />}/>
        <Route path="*" element={<div>404 Not Found</div>}/>
      </Route>
    </Routes>
    </AnimatePresence>
  )
}

export default App
