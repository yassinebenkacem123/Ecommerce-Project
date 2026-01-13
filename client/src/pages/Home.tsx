import HeroSection from '../components/hero/HeroSection'
import type {JSX} from "react";
import AboutUs from '../components/sections/aboutus/AboutUs';
import OurAmazingCameras from '../components/sections/details/OurAmazingCameras';
import ExploreSection from '../components/sections/explore/ExploreSection';
import ProductDetails from '../components/sections/productDetails/ProductDetails';
const Home = ():JSX.Element => {
  return (
    <> 
      <HeroSection  />  
      <AboutUs  />
      <OurAmazingCameras  />
      <ExploreSection />
      <ProductDetails />
    </>
  )
}

export default Home