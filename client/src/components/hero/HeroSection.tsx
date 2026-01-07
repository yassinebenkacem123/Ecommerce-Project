import Title from "./Title"
import CTAComponent from "./CTAComponent"
import type { JSX } from "react";
const HeroSection = (): JSX.Element => {
  return (
    <section className='h-screen flex flex-col gap-4 py-4'>
      <Title  />
      <CTAComponent />
      <div>
        hellow wolrd
      </div>
    </section>
  )
}

export default HeroSection