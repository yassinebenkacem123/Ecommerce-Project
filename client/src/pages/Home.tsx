import HeroSection from '../components/hero/HeroSection'
import type {JSX} from "react";
import AboutUs from '../components/sections/aboutus/AboutUs';
const Home = ():JSX.Element => {
  return (
    <> 
      <HeroSection  />  
      <AboutUs  />
    </>
  )
}

export default Home