import { IoCloseOutline } from "react-icons/io5";
import { Link } from "react-router";
import type { JSX } from "react";
import { motion } from "framer-motion";
import { 
    FaFacebook,  
    FaInstagram,
    FaDiscord,
    FaWhatsapp
} from "react-icons/fa6";
import type React from "react";

type MenuContentProps = {
    setOpenMenu:React.Dispatch<React.SetStateAction<boolean>>;
}

const MenuContent = ({setOpenMenu}: MenuContentProps):JSX.Element => {
    const links:string[] = [
        'Home',
        'Products',
        'About Us',
        'Contact',
        'Blog',
    ]
    const socialLinks:{name: string, icon: JSX.Element, url: string}[] = [
        {
            name: 'Facebook',
            icon: <FaFacebook />,
            url:"",
        },
        {
            name:"instagram",
            icon:<FaInstagram />,
            url:"",
        },
        {
            name:"Discord",
            icon:<FaDiscord />,
            url:"",
        },
        {
            name:"Whatsapp",
            icon:<FaWhatsapp />,
            url:"",
        }
    ]
  return (
<motion.section 
    variants={{
        hidden:{x:-140, opacity:0},
        visible:{x:0, opacity:1},
    }}
    initial="hidden"
    animate="visible"
    transition={{duration:0.75, ease:"easeOut", delay:0.2}}

    className='inset-0 p-20 flex flex-col gap-10 absolute z-100 bg-stone-900 '>
    <div className="flex gap-30">
        <div>
            {/* closse button */}
            <button
                title="close menu"  
                className="text-yellow-50"
                onClick={() => setOpenMenu(false)}
                >
                <IoCloseOutline size={50}/>
            </button>
        </div>
        <div className="flex flex-col gap-20">
           <div className="flex flex-col gap-5">
                 {links.map((link:string, index:number) => (
                <Link
                    className="text-yellow-50 text-5xl" 
                    to={`/${link.toLowerCase()}`}
                    key={index}
                    >
                    {link}
                </Link>
            ))}
           </div>
            <div className="flex gap-10">
                {socialLinks.map((social, index) => (
                <a title={social.name}
                    key={index}
                    href={social.url}
                    className="text-yellow-50 cursor-pointer text-3xl flex items-center gap-2"
                    rel="noopener noreferrer"
                    >
                    {social.icon}
                </a>
            ))}
            </div>
        </div>
    </div>   

    </motion.section>
  )
}

export default MenuContent