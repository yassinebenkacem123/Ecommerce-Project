import HeroSection from '../components/hero/HeroSection'
import type {JSX} from "react";
import AboutUs from '../components/sections/aboutus/AboutUs';
import OurAmazingCameras from '../components/sections/details/OurAmazingCameras';
import ExploreSection from '../components/sections/explore/ExploreSection';
import ProductDetails from '../components/sections/productDetails/ProductDetails';
import ShownCreativity from '../components/sections/shownCreativity/ShownCreativity';
import Subscribe from '../components/sections/subscribe/Subscribe';
const Home = ():JSX.Element => {
  return (
    <>
      <main className='px-12 md:px-15 lg:px-18'> 
        <HeroSection  />  
        <AboutUs  />
        <OurAmazingCameras  />
      </main>
      <ExploreSection />
      <main> 
        <ProductDetails />
        <ShownCreativity  />
        <Subscribe  />
      </main>
    </>
  )
}

export default Home