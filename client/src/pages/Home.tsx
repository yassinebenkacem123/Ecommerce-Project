import HeroSection from '../components/hero/HeroSection'
import type {JSX} from "react";
import AboutUs from '../components/sections/aboutus/AboutUs';
import OurAmazingCameras from '../components/sections/details/OurAmazingCameras';
import ExploreSection from '../components/sections/explore/ExploreSection';
import ProductDetails from '../components/sections/productDetails/ProductDetails';
import ShownCreativity from '../components/sections/shownCreativity/ShownCreativity';
import Subscribe from '../components/sections/subscribe/Subscribe';
import Template from '../utils/Template';
const Home = ():JSX.Element => {
  return (
    <Template>
      <main className='px-12 md:px-15 lg:px-18'> 
        <HeroSection  />  
        <AboutUs  />
        <OurAmazingCameras  />
      </main>
      <ExploreSection />
      <main className='px-12 md:px-15 lg:px-18'> 
        <ProductDetails />
        <ShownCreativity  />
        <Subscribe  />
      </main>
    </Template>
  )
}

export default Home